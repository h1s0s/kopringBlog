package com.example.kopringBlog.service.user

import com.example.kopringBlog.domain.blog.Blog
import com.example.kopringBlog.domain.blog.BlogRepository
import com.example.kopringBlog.domain.user.User
import com.example.kopringBlog.domain.user.UserRepository
import com.example.kopringBlog.dto.user.UserCreateRequest
import com.example.kopringBlog.dto.user.UserDeleteRequest
import com.example.kopringBlog.dto.user.UserLoginRequest
import org.springframework.data.repository.findByIdOrNull
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

    fun getUser(request: UserLoginRequest): User?{
        return userRepository.findById(request.id, request.password)
    }

    @Transactional
    fun userDelete(request: UserDeleteRequest){
        val user = userRepository.findByIdOrNull(request.userNo) ?: throw IllegalArgumentException("존재하지 않는 ID입니다.")
        user.stateToDeleted()
    }
}