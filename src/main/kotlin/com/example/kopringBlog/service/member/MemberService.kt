package com.example.kopringBlog.service.member

import com.example.kopringBlog.domain.blog.Blog
import com.example.kopringBlog.domain.blog.BlogRepository
import com.example.kopringBlog.domain.member.Member
import com.example.kopringBlog.domain.member.MemberRepository
import com.example.kopringBlog.domain.member.MemberState
import com.example.kopringBlog.dto.member.MemberCreateRequest
import com.example.kopringBlog.dto.member.MemberDeleteRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class MemberService(
    private val memberRepository: MemberRepository,
    private val blogRepository: BlogRepository,
) {

    @Transactional
    fun createMember(request: MemberCreateRequest){
        val newUser = Member(request.memberId, request.password, MemberState.NORMAL)
        val newBlog = Blog(request.memberId + "의 블로그", "default")
        memberRepository.save(newUser)
        blogRepository.save(newBlog)
    }

    @Transactional
    fun getMember(memberId: String): Member?{
        return memberRepository.findByMemberId(memberId)
    }

    @Transactional
    fun deleteMember(request: MemberDeleteRequest){
        val member = memberRepository.findByIdOrNull(request.memberNo) ?: throw IllegalArgumentException("존재하지 않는 ID입니다.")
        member.stateToDeleted()
    }
}