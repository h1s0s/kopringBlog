package com.example.kopringBlog.domain.post

import com.example.kopringBlog.domain.user.User
import org.springframework.data.jpa.repository.JpaRepository

interface PostRepository : JpaRepository<Post, Long> {
}