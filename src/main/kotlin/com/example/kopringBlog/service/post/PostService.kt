package com.example.kopringBlog.service.post

import com.example.kopringBlog.domain.post.PostRepository
import org.springframework.stereotype.Service

@Service
class PostService(
    private val postRepository: PostRepository,
) {
}