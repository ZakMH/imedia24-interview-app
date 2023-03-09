package com.imedia24.interviewapp.controller

import com.imedia24.interviewapp.dto.ProductDto
import com.imedia24.interviewapp.model.Product
import com.imedia24.interviewapp.service.ProductService
import jakarta.validation.Valid
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/products")
class ProductController(val productService: ProductService) {

    @GetMapping("/")
    fun getProducts(): ResponseEntity<List<Product>> {
        val products = productService.getProducts()
        return ResponseEntity.ok(products)
    }

    @GetMapping("/{id}")
    fun getProductById(@PathVariable id: Long): ResponseEntity<Product> {
        val product = productService.getProductById(id)
        return ResponseEntity.ok(product)
    }

    @PostMapping("/")
    fun addProduct(@Valid @RequestBody productDto: ProductDto): ResponseEntity<Product> {
        val product = productService.addProduct(productDto)
        return ResponseEntity(product, HttpStatusCode.valueOf(201))
    }

    @DeleteMapping("/{id}")
    fun removeProduct(@PathVariable id: Long): ResponseEntity<Any> {
        productService.removeProduct(id)
        return ResponseEntity.noContent().build()
    }

    @PutMapping("/{id}")
    fun updateProduct(@PathVariable id: Long, @Valid @RequestBody productDto: ProductDto): ResponseEntity<Product> {
        val product = productService.updateProduct(id, productDto)
        return ResponseEntity(product, HttpStatusCode.valueOf(204))
    }

    @PutMapping("/{id}/bind-to-category/{categoryId}")
    fun bindToCategory(@PathVariable id: Long, @PathVariable categoryId: Long): ResponseEntity<Any> {
        val product = productService.bindToCategory(id, categoryId)
        return ResponseEntity(product, HttpStatusCode.valueOf(204))
    }
    @PutMapping("/{id}/unbind-from-category/{categoryId}")
    fun unbindFromCategory(@PathVariable id: Long, @PathVariable categoryId: Long): ResponseEntity<Any> {
        val product = productService.unbindFromCategory(id, categoryId)
        return ResponseEntity(product, HttpStatusCode.valueOf(204))
    }

}