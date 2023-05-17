package com.example.kopringBlog.service.user

import com.example.kopringBlog.domain.user.User
import com.example.kopringBlog.domain.user.UserRepository
import com.example.kopringBlog.service.UserService
import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class UserServiceTest @Autowired constructor(
    private val userService: UserService,
    private val userRepository: UserRepository,
) {

    @Test
    @DisplayName("유저 저장이 성공했습니다")
    fun saveTest(){
        //given
        val newUser = User("test", "1234")

        //when
        userRepository.save(newUser)

        //then
        val results = userRepository.findAll()
        assertThat(results).hasSize(1)
        assertThat(results[0].id).isEqualTo("test")
        assertThat(results[0].password).isEqualTo("1234")

    }
}