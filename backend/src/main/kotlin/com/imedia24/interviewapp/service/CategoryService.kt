package com.imedia24.interviewapp.service

import com.imedia24.interviewapp.dto.CategoryDto
import com.imedia24.interviewapp.model.Category
import com.imedia24.interviewapp.repository.CategoryRepository
import com.imedia24.interviewapp.util.CategoryMapper
import org.springframework.stereotype.Service

@Service
class CategoryService(val categoryRepository: CategoryRepository) {

    fun getCategories(): List<Category> = categoryRepository.findAll().toList()

    fun getCategoryById(id: Long): Category = categoryRepository.findById(id).get()

    fun addCategory(categoryDto: CategoryDto): Category {
        val category = CategoryMapper.dtoToEntity(categoryDto)
        return categoryRepository.save(category)
    }

    fun removeCategory(id: Long) = categoryRepository.deleteById(id)

    fun updateCategory(id: Long, categoryDto: CategoryDto): Category {
        val category = getCategoryById(id)
        category.name = categoryDto.name
        return categoryRepository.save(category)
    }

    fun bindSubCategory(id: Long, subId: Long): Category {
        val category = getCategoryById(id)
        val subCategory = getCategoryById(subId)
        subCategory.parentCategory = category
        return categoryRepository.save(subCategory)
    }

    fun unbindSubCategory(subId: Long): Category {
        val subCategory = getCategoryById(subId)
        subCategory.parentCategory = null
        return categoryRepository.save(subCategory)
    }

    fun isParentCategory(id: Long, subId: Long): Boolean {
        val category = getCategoryById(id)
        val subCategory = getCategoryById(subId)
        return category.subCategories.contains(subCategory)
    }
}