package com.imedia24.interviewapp.service

import com.imedia24.interviewapp.model.Category
import com.imedia24.interviewapp.repository.CategoryRepository
import jakarta.persistence.EntityNotFoundException
import org.springframework.stereotype.Service
import java.util.*

@Service
class CategoryService(val categoryRepository: CategoryRepository, val productService: ProductService) {

    fun getCategories(): List<Category> = categoryRepository.findAll().toList()

//    fun getCategriesWithChildCategories(): List<Category> = getCategories().map { category: Category? -> category.subCategories }

    fun getCategoryById(id: Long): Optional<Category> = categoryRepository.findById(id)

    fun addCategory(category: Category): Category = categoryRepository.save(category)

    fun removeCategory(id: Long) = categoryRepository.deleteById(id)

    fun updateCategory(id: Long, name: String): Category {
        val category = getCategoryById(id)
            .orElseThrow { EntityNotFoundException("Category with id $id not found") }
        category.name = name
        return categoryRepository.save(category)
    }

    fun addChildCategory(id: Long, childId: Long): Category {
        val category =
            getCategoryById(id).orElseThrow { EntityNotFoundException("Category with id $id not found") }

        val childCategory =
            getCategoryById(childId).orElseThrow { EntityNotFoundException("Category with id $childId not found") }

        childCategory.parentCategory = category

        return categoryRepository.save(childCategory)
    }

    //    fun bindCategoryToParentCategory(categoryId: Long, parentId: Long): Category {
//        val category = categoryRepository.findById(categoryId)
//            .orElseThrow { throw EntityNotFoundException("Category with id $categoryId not found") }
//        val parentCategory = categoryRepository.findById(parentId)
//            .orElseThrow { throw EntityNotFoundException("Category with id $parentId not found") }
//        if (parentCategory.parentCategory?.id == categoryId)
//            throw Exception("Category ${category.id} cannot be a parent and a child at the same time")
//        category.parentCategory = parentCategory
//        return categoryRepository.save(category)
//    }

    fun removeChildCategory(id: Long, childId: Long): Category {
        val category =
            getCategoryById(id).orElseThrow { EntityNotFoundException("Category with id $id not found") }

        val childCategory =
            getCategoryById(childId).orElseThrow {
                EntityNotFoundException("Category with id $childId not found")
            }

        childCategory.parentCategory = null

        return categoryRepository.save(childCategory)
    }

    fun addProductToCategory(categoryId: Long, productId: Long): Optional<Category> {
        val category =
            getCategoryById(categoryId).orElseThrow { EntityNotFoundException("Category with id $categoryId not found") }
        val product = productService.getProductById(productId)
            .orElseThrow { EntityNotFoundException("Product with id $productId not found") }

        product.parentCategory = product.parentCategory?.plus(category)
        productService.addProduct(product)

        return getCategoryById(category.id)
    }

    fun removeProductFromCategory(categoryId: Long, productId: Long): Optional<Category> {
        val category =
            getCategoryById(categoryId).orElseThrow { EntityNotFoundException("Category with id $categoryId not found") }
        val product = productService.getProductById(productId)
            .orElseThrow { EntityNotFoundException("Product with id $productId not found") }

        product.parentCategory = product.parentCategory?.minus(category)
        productService.addProduct(product)

        return getCategoryById(category.id)
    }
}