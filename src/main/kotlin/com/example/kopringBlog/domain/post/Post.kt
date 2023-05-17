package com.example.kopringBlog.domain.post

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Post(
    val title: String,
    val content: String,
    val regDate: String,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val postNo: Long? = null
) {
}