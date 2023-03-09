package com.imedia24.interviewapp.util

import com.imedia24.interviewapp.dto.ProductDto
import com.imedia24.interviewapp.model.Product

class ProductMapper {
    companion object {
        fun dtoToEntity(dto: ProductDto): Product {
            return Product(name = dto.name, price = dto.price, image = dto.image)
        }

        fun entityToDto(entity: Product): ProductDto {
            return ProductDto(entity.name, Product.CURRENCY, entity.price)
        }
    }
}