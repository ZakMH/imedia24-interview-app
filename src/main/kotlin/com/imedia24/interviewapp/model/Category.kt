package com.imedia24.interviewapp.model


import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonManagedReference
import jakarta.persistence.*

@Entity
class Category(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    var name: String? = "Insert category name",

    @ManyToMany(mappedBy = "parentCategory", fetch = FetchType.LAZY)
    @JsonManagedReference
    var products: Set<Product> = emptySet(),

    @ManyToOne
    @JoinColumn(name = "parent_id")
    @JsonIgnoreProperties("subCategories")
    var parentCategory: Category? = null,

    @OneToMany(mappedBy = "parentCategory")
    @JsonIgnoreProperties("parentCategory")
    var subCategories: Set<Category> = emptySet()
)