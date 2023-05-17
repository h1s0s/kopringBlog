package com.example.kopringBlog.domain.category

import com.example.kopringBlog.domain.user.User
import org.springframework.data.jpa.repository.JpaRepository

interface CategoryRepository : JpaRepository<Category, Long> {
}