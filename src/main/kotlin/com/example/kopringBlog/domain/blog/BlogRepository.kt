package com.example.kopringBlog.domain.blog

import com.example.kopringBlog.domain.user.User
import org.springframework.data.jpa.repository.JpaRepository

interface BlogRepository : JpaRepository<Blog, Long> {
}