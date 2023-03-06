package com.imedia24.interviewapp.service

import com.imedia24.interviewapp.model.Category
import com.imedia24.interviewapp.repository.CategoryRepository
import jakarta.persistence.EntityNotFoundException
import org.springframework.stereotype.Service
import java.util.*

@Service
class CategoryService(val categoryRepository: CategoryRepository) {

    fun getCategories(): List<Category> = categoryRepository.findAll().toList()

    fun getCategoryById(id: Long): Optional<Category> = categoryRepository.findById(id)

    fun addCategory(category: Category): Category = categoryRepository.save(category)

    fun removeCategory(id: Long) = categoryRepository.deleteById(id)

    fun updateCategory(id: Long, name: String): Category {
        val category = getCategoryById(id)
            .orElseThrow { EntityNotFoundException("Category with id $id not found") }
        category.name = name
        return categoryRepository.save(category)
    }
}