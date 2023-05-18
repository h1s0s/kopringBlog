package com.example.kopringBlog.domain.blog

import org.springframework.data.jpa.repository.JpaRepository

interface BlogRepository : JpaRepository<Blog, Long> {

}