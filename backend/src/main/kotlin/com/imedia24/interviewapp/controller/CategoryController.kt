package com.imedia24.interviewapp.controller

import com.imedia24.interviewapp.dto.CategoryDto
import com.imedia24.interviewapp.model.Category
import com.imedia24.interviewapp.service.CategoryService
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/categories")
class CategoryController(val categoryService: CategoryService) {

    @GetMapping("/")
    fun getCategories(): ResponseEntity<List<Category>> {
        val categories = categoryService.getCategories()
        return ResponseEntity.ok(categories)
    }

    @GetMapping("/{id}")
    fun getCategoryById(@PathVariable id: Long): ResponseEntity<Category> {
        val category = categoryService.getCategoryById(id)
        return ResponseEntity.ok(category)
    }

    @PostMapping("/")
    fun addCategory(@RequestBody categoryDto: CategoryDto): ResponseEntity<Category> {
        val category = categoryService.addCategory(categoryDto)
        return ResponseEntity(category, HttpStatusCode.valueOf(201))
    }

    @DeleteMapping("/{id}")
    fun removeCategory(@PathVariable id: Long): ResponseEntity<Any> {
        categoryService.removeCategory(id)
        return ResponseEntity.noContent().build()
    }

    @PutMapping("/{id}")
    fun updateCategory(@PathVariable id: Long, @RequestBody categoryDto: CategoryDto): ResponseEntity<Category> {
        val category = categoryService.updateCategory(id, categoryDto)
        return ResponseEntity(category, HttpStatusCode.valueOf(204))
    }

    @PutMapping("/{id}/bind-sub-category/{subId}")
    fun bindSubCategory(@PathVariable id: Long, @PathVariable subId: Long): ResponseEntity<Any> {
        if (categoryService.isParentCategory(subId, id))
            return ResponseEntity(
                mapOf("message" to "Category with id $subId cannot be parent & child at once of Category with id $id"),
                HttpStatusCode.valueOf(400)
            )
        val category = categoryService.bindSubCategory(id, subId)
        return ResponseEntity(category, HttpStatusCode.valueOf(204))
    }

    @PutMapping("/{id}/unbind-sub-category/{subId}")
    fun unbindSubCategory(@PathVariable id: Long, @PathVariable subId: Long): ResponseEntity<Any> {
        if (!categoryService.isParentCategory(id, subId))
            return ResponseEntity(
                mapOf("message" to "Category with id $id isn't the parent of Category with id $subId"),
                HttpStatusCode.valueOf(400)
            )
        val category = categoryService.unbindSubCategory(subId)
        return ResponseEntity(category, HttpStatusCode.valueOf(204))
    }
}