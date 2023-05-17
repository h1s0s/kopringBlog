package com.example.kopringBlog.domain.user

import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long>{

    fun findById(userId: String, password: String): User?
}