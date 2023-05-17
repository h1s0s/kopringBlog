package com.example.kopringBlog.domain.user

import org.springframework.data.jpa.repository.JpaRepository

interface MemberRepository : JpaRepository<Member, Long>{

    fun findByMemberId(memberId: String): Member?
}