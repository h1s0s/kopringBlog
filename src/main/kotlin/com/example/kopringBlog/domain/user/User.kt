package com.example.kopringBlog.domain.user

import javax.persistence.*

@Entity
@Table(name="Users")
class User(
    val id: String,
    val password: String,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val userNo: Long? = null,
) {
}