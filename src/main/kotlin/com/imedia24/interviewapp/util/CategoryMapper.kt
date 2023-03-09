package com.imedia24.interviewapp.util

import com.imedia24.interviewapp.dto.CategoryDto
import com.imedia24.interviewapp.model.Category

class CategoryMapper {

    companion object {
        fun dtoToEntity(dto: CategoryDto): Category {
            return Category(name = dto.name)
        }

        fun entityToDto(entity: Category): CategoryDto {
            return CategoryDto(entity.name)
        }
    }
}