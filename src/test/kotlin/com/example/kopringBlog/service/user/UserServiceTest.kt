package com.example.kopringBlog.service.user

import com.example.kopringBlog.domain.blog.BlogRepository
import com.example.kopringBlog.domain.user.User
import com.example.kopringBlog.domain.user.UserRepository
import com.example.kopringBlog.domain.user.UserState
import com.example.kopringBlog.dto.user.UserCreateRequest
import com.example.kopringBlog.dto.user.UserDeleteRequest
import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class UserServiceTest @Autowired constructor(
    private val userService: UserService,
    private val userRepository: UserRepository,
    private val blogRepository: BlogRepository,
) {
    @AfterEach
    fun clean(){
        userRepository.deleteAll()
        blogRepository.deleteAll()
    }

    @Test
    @DisplayName("유저 회원가입 성공")
    fun saveTest(){
        //given
        val newUser = User.fixture("test", "1234")

        //when
        userRepository.save(newUser)

        //then
        val results = userRepository.findAll()
        assertThat(results).hasSize(1)
        assertThat(results[0].id).isEqualTo("test")
        assertThat(results[0].password).isEqualTo("1234")
    }

    @Test
    @DisplayName("유저 블로그 생성 성공")
    fun userBlogInsertTest(){
        //given
        val newUser = User.fixture("test", "1234")

        //when
        userService.createUser(UserCreateRequest(newUser.id, newUser.password))

        //then
        val results = blogRepository.findAll()
        assertThat(results).hasSize(1)
        assertThat(results[0].title).isEqualTo(newUser.id+"의 블로그")
    }

    @Test
    @DisplayName("로그인 성공")
    fun loginTest(){

    }

    @DisplayName("유저 정보 수정 성공")
    fun userUpdateTest(){

    }

    @Test
    @DisplayName("유저 탈퇴 성공")
    fun userSecessionTest(){
        //given
        val newUser = User.fixture("test", "1234")
        userRepository.save(newUser)

        //when
        userService.userDelete(UserDeleteRequest(newUser.userNo!!))

        //then
        val results = userRepository.findAll()
        assertThat(results[0].state).isEqualTo(UserState.DELETED)
    }
}