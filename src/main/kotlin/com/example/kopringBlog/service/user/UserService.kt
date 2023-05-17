package com.example.kopringBlog.service.user

import com.example.kopringBlog.domain.blog.Blog
import com.example.kopringBlog.domain.blog.BlogRepository
import com.example.kopringBlog.domain.user.User
import com.example.kopringBlog.domain.user.UserRepository
import com.example.kopringBlog.dto.user.UserCreateRequest
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService(
    private val userRepository: UserRepository,
    private val blogRepository: BlogRepository,
) {

    @Transactional
    fun createUser(request: UserCreateRequest){
        val newUser = User(request.id, request.password)
        val newBlog = Blog(request.id + "의 블로그", "default")
        userRepository.save(newUser)
        blogRepository.save(newBlog)
    }
}