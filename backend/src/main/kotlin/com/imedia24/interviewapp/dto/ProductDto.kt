package com.imedia24.interviewapp.dto

import jakarta.validation.constraints.Positive
import jakarta.validation.constraints.Size

data class ProductDto(
    var name: String?,

    var image: String?,

    @field:Positive
    var price: Double?,

    @field:Size(min = 3, max = 3)
    var currency: String? = null
)