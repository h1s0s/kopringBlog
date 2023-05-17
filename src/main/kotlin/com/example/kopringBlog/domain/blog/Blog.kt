package com.example.kopringBlog.domain.blog

import com.example.kopringBlog.domain.category.Category
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.OneToMany

@Entity
class Blog(
    val title: String,
    val logoPath: String,

    @OneToMany
    @JoinColumn(name = "category_id")
    val categories: MutableList<Category> = mutableListOf(),

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val blogNo: Long? = null,
) {
}