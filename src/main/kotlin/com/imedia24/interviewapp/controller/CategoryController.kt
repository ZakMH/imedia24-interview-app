package com.imedia24.interviewapp.controller

import com.imedia24.interviewapp.model.Category
import com.imedia24.interviewapp.service.CategoryService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/categories")
class CategoryController(val categoryService: CategoryService) {

    @GetMapping("/")
    fun getCategories() = categoryService.getCategories()

    @GetMapping("/{id}")
    fun getCategoryById(@PathVariable id: Long) = categoryService.getCategoryById(id)

    @PostMapping("/")
    fun addCategory(@RequestBody category: Category) = categoryService.addCategory(category)

    @DeleteMapping("/{id}")
    fun removeCategory(@PathVariable id: Long) = categoryService.removeCategory(id)

    @PutMapping("/{id}")
    fun updateCategory(@PathVariable id: Long, @RequestBody update: Map<String, String>) =
        categoryService.updateCategory(id, update["name"]!!)
}