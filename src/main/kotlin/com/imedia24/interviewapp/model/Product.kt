package com.imedia24.interviewapp.model


import com.fasterxml.jackson.annotation.JsonBackReference
import jakarta.persistence.*

@Entity
class Product(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = 0,

    var name: String,

    var price: Double,

    var image: String,

    @ManyToMany
    @JoinTable(
        joinColumns = [JoinColumn(name = "product_id")],
        inverseJoinColumns = [JoinColumn(name = "category_id")]
    )
    @JsonBackReference
    var parentCategory: Set<Category>? = emptySet()
)