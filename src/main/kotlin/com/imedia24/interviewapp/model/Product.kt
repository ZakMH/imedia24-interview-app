package com.imedia24.interviewapp.model


import com.fasterxml.jackson.annotation.JsonBackReference
import jakarta.persistence.*

@Entity
class Product(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = 0,

    var name: String? = "Insert product name",

    var image: String? = "/img/no-img.jpg",

    var price: Double? = 0.0,

    @ManyToMany
    @JoinTable(
        joinColumns = [JoinColumn(name = "product_id")],
        inverseJoinColumns = [JoinColumn(name = "category_id")]
    )
    @JsonBackReference
    var parentCategory: Set<Category>? = emptySet()
) {
    companion object {
        const val CURRENCY = "EUR"
    }
}
