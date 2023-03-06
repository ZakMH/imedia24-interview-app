package com.imedia24.interviewapp.service

import com.imedia24.interviewapp.model.Product
import com.imedia24.interviewapp.repository.ProductRepository
import jakarta.persistence.EntityNotFoundException
import org.springframework.stereotype.Service
import java.util.*

@Service
class ProductService(val productRepository: ProductRepository) {
    fun getProducts(): List<Product> = productRepository.findAll().toList()

    fun getProductById(id: Long): Optional<Product> = productRepository.findById(id)

    fun addProduct(product: Product): Product = productRepository.save(product)

    fun removeProduct(id: Long) = productRepository.deleteById(id)

    fun updateProduct(id: Long, updates: Map<String, Any>): Product {
        val product = getProductById(id)
            .orElseThrow { EntityNotFoundException("Product with id $id not found") }
        updates.forEach { (key, value) ->
            when (key) {
                "name" -> product.name = value as String
                "image" -> product.image = value as String
                "price" -> product.price = if (value is Int) value.toDouble() else value as Double
                else -> throw IllegalArgumentException("Invalid field: $key")
            }
        }
        return productRepository.save(product)
    }
}