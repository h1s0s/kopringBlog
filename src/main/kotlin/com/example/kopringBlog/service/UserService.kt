package com.example.kopringBlog.service

import com.example.kopringBlog.domain.user.User
import com.example.kopringBlog.domain.user.UserRepository
import com.example.kopringBlog.dto.user.UserCreateRequest
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService(
    private val userRepository: UserRepository
) {

    @Transactional
    fun saveUser(request: UserCreateRequest){
        val newUser = User(request.id, request.password)
        userRepository.save(newUser)
    }
}