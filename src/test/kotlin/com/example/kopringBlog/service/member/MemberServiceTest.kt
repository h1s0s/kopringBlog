package com.example.kopringBlog.service.member

import com.example.kopringBlog.domain.blog.BlogRepository
import com.example.kopringBlog.domain.member.Member
import com.example.kopringBlog.domain.member.MemberRepository
import com.example.kopringBlog.domain.member.MemberState
import com.example.kopringBlog.dto.member.MemberCreateRequest
import com.example.kopringBlog.dto.member.MemberDeleteRequest
import com.example.kopringBlog.repository.member.MemberQueryRepository
import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class MemberServiceTest @Autowired constructor(
    private val memberService: MemberService,
    private val memberRepository: MemberRepository,
    private val blogRepository: BlogRepository,
    private val memberQueryRepository: MemberQueryRepository,

    ) {
    @AfterEach
    fun clean(){
        memberRepository.deleteAll()
        blogRepository.deleteAll()
    }

    @Test
    @DisplayName("유저 회원가입 성공")
    fun saveTest(){
        //given
        val newUser = Member.fixture("test", "1234")

        //when
        memberRepository.save(newUser)

        //then
        val results = memberRepository.findAll()
        assertThat(results).hasSize(1)
        assertThat(results[0].memberId).isEqualTo("test")
        assertThat(results[0].password).isEqualTo("1234")
    }

    @Test
    @DisplayName("유저 블로그 생성 성공")
    fun memberBlogInsertTest(){
        //given
        val newUser = Member.fixture("test", "1234", "test")

        //when
        memberService.createMember(MemberCreateRequest(newUser.memberId, newUser.password, newUser.memberName))

        //then
        val results = blogRepository.findAll()
        assertThat(results).hasSize(1)
        assertThat(results[0].title).isEqualTo(newUser.memberId+"의 블로그")
    }

//    @Test
//    @DisplayName("로그인 성공")
//    fun loginTest(){
//
//    }
//
//    @DisplayName("유저 정보 수정 성공")
//    fun userUpdateTest(){
//
//    }

    @Test
    @DisplayName("유저 탈퇴 성공")
    fun memberSecessionTest(){
        //given
        val newUser = Member.fixture("test", "1234")
        memberRepository.save(newUser)

        //when
        memberService.deleteMember(MemberDeleteRequest(newUser.memberNo!!))

        //then
        val results = memberRepository.findAll()
        assertThat(results[0].state).isEqualTo(MemberState.DELETED)
    }
}