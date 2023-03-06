package com.imedia24.interviewapp.repository

import com.imedia24.interviewapp.model.Category
import org.springframework.data.repository.CrudRepository

interface CategoryRepository : CrudRepository<Category, Long> {
}