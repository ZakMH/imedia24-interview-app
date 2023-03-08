package com.imedia24.interviewapp.service

import com.imedia24.interviewapp.dto.ProductDto
import com.imedia24.interviewapp.model.Product
import com.imedia24.interviewapp.repository.ProductRepository
import com.imedia24.interviewapp.util.CurrencyChecker
import com.imedia24.interviewapp.util.FixerApiClient
import com.imedia24.interviewapp.util.ProductMapper
import org.springframework.stereotype.Service

@Service
class ProductService(
    val productRepository: ProductRepository,
    val categoryService: CategoryService,
    val fixerApiClient: FixerApiClient
) {
    fun getProducts(): List<Product> = productRepository.findAll().toList()

    fun getProductById(id: Long): Product =
        productRepository.findById(id).get()

    fun addProduct(productDto: ProductDto): Product {
//        TODO: refactor implementation
        val (_, _, price, currency) = productDto
        val convertedPrice = if (currency != null && CurrencyChecker.isValidCurrencyCode(currency) && price != null)
            fixerApiClient.convert(Product.CURRENCY, currency, price)?.result
        else productDto.price
        val product = ProductMapper.dtoToEntity(productDto)
        if (price != null) product.price = convertedPrice
        return productRepository.save(product)
    }

    fun removeProduct(id: Long) = productRepository.deleteById(id)

    fun updateProduct(id: Long, productDto: ProductDto): Product {
        val product = getProductById(id)
        product.name = productDto.name ?: product.name
        product.price = productDto.price ?: product.price
        product.image = productDto.image ?: product.image
        return productRepository.save(product)
    }

    fun bindToCategory(id: Long, categoryId: Long): Product {
        val product = getProductById(id)
        val category = categoryService.getCategoryById(categoryId)
        product.parentCategory = product.parentCategory?.plus(category)
        return productRepository.save(product)
    }

    fun unbindFromCategory(id: Long, categoryId: Long): Product {
        val product = getProductById(id)
        val category = categoryService.getCategoryById(categoryId)
        product.parentCategory = product.parentCategory?.minus(category)
        return productRepository.save(product)
    }
}