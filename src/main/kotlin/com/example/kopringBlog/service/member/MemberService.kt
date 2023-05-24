package com.example.kopringBlog.service.member

import com.example.kopringBlog.domain.blog.Blog
import com.example.kopringBlog.domain.blog.BlogRepository
import com.example.kopringBlog.domain.category.Category
import com.example.kopringBlog.domain.category.CategoryRepository
import com.example.kopringBlog.domain.member.Member
import com.example.kopringBlog.domain.member.MemberRepository
import com.example.kopringBlog.domain.member.MemberState
import com.example.kopringBlog.dto.member.MemberCreateRequest
import com.example.kopringBlog.dto.member.MemberDeleteRequest
import com.example.kopringBlog.repository.member.MemberQueryRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class MemberService(
    private val memberRepository: MemberRepository,
    private val blogRepository: BlogRepository,
    private val categoryRepository: CategoryRepository,
    private val memberQueryRepository: MemberQueryRepository,
) {

    @Transactional
    fun createMember(request: MemberCreateRequest){
        val newUser = Member(request.memberId, request.password, request.memberName, MemberState.NORMAL)
        val newBlog = Blog(request.memberId + "의 블로그", "spring-logo.jpg")
        val newCategory = Category("미분류", "기본으로 만들어지는 카테고리 입니다.")
        memberRepository.save(newUser)
        blogRepository.save(newBlog)
        categoryRepository.save(newCategory)
    }

    @Transactional
    fun getMember(memberId: String): Member?{
        return memberQueryRepository.find(memberId)
    }

    @Transactional
    fun deleteMember(request: MemberDeleteRequest){
        val member = memberRepository.findByIdOrNull(request.memberNo) ?: throw IllegalArgumentException("존재하지 않는 ID입니다.")
        member.stateToDeleted()
    }
}