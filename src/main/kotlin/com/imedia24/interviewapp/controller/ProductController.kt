package com.imedia24.interviewapp.controller

import com.imedia24.interviewapp.model.Product
import com.imedia24.interviewapp.service.ProductService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/products")
class ProductController(val productService: ProductService) {

    @GetMapping("/")
    fun getProducts() = productService.getProducts()

    @GetMapping("/{id}")
    fun getProductById(@PathVariable id: Long) = productService.getProductById(id)

    @PostMapping("/")
    fun addProduct(@RequestBody product: Product): Product = productService.addProduct(product)

    @DeleteMapping("/{id}")
    fun removeProduct(@PathVariable id: Long) = productService.removeProduct(id)

    @PutMapping("/{id}")
    fun updateProduct(@PathVariable id: Long, @RequestBody updates: Map<String, Any>) = productService.updateProduct(id, updates)
}