package com.imedia24.interviewapp.model


import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonManagedReference
import jakarta.persistence.*

@Entity
class Category(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    var name: String,

    @ManyToMany(mappedBy = "parentCategory", fetch = FetchType.LAZY)
    @JsonManagedReference
    var products: Set<Product> = emptySet(),

    @ManyToOne
    @JoinColumn(name = "parent_id")
    @JsonBackReference
    var parentCategory: Category?,

    @OneToMany(mappedBy = "parentCategory")
    @JsonManagedReference
    var subCategories: Set<Category> = emptySet()
)