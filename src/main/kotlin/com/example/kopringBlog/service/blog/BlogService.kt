package com.example.kopringBlog.service.blog

import com.example.kopringBlog.domain.blog.Blog
import com.example.kopringBlog.domain.blog.BlogRepository
import com.example.kopringBlog.domain.member.Member
import com.example.kopringBlog.domain.member.MemberRepository
import com.example.kopringBlog.dto.blog.BlogUpdateRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class BlogService(
    private val blogRepository: BlogRepository,
    private val memberRepository: MemberRepository,
) {
    @Transactional
    fun getBlog(memberId: String): Member {
        return memberRepository.findByMemberId(memberId) ?: throw IllegalArgumentException("존재하지 않는 회원입니다")
    }

    @Transactional
    fun updateTitle(request: BlogUpdateRequest){
        val blog = blogRepository.findByIdOrNull(request.blogNo) ?: throw IllegalArgumentException("존재하지 않는 아이디입니다")
        blog.updateTitle(request.title)
    }

    @Transactional
    fun updateLogo(request: BlogUpdateRequest){
        val blog = blogRepository.findByIdOrNull(request.blogNo) ?: throw IllegalArgumentException("존재하지 않는 아이디입니다")
        blog.updateLogo(request.logoPath!!)
    }
}