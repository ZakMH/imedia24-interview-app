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

    @PutMapping("/{id}/sub-categories/{childId}")
    fun addChildCategory(@PathVariable id: Long, @PathVariable childId: Long) =
        categoryService.addChildCategory(id, childId)

//    @PutMapping("{id}/bind-parent-category/{parentId}")
//    fun bindCategoryToParentCategory(@PathVariable id: Long, @PathVariable parentId: Long) =
//        categoryService.bindCategoryToParentCategory(id, parentId)

    @PutMapping("/{id}/unbind-parent-category")
    fun unbindCategoryToParentCategory(@PathVariable id: Long, @PathVariable childId: Long) =
        categoryService.removeChildCategory(id, childId)

    @PutMapping("/{id}/add-product/{productId}")
    fun addProductToCategory(@PathVariable id: Long, @PathVariable productId: Long) =
        categoryService.addProductToCategory(id, productId)

    @PutMapping("/{id}/drop-product/{productId}")
    fun removeProductFromCategory(@PathVariable id: Long, @PathVariable productId: Long) =
        categoryService.removeProductFromCategory(id, productId)
}