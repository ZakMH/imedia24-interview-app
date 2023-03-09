package com.imedia24.interviewapp.repository

import com.imedia24.interviewapp.model.Product
import org.springframework.data.repository.CrudRepository

interface ProductRepository : CrudRepository<Product, Long>