package com.example.kopringBlog.repository.member

import com.example.kopringBlog.domain.member.Member
import com.example.kopringBlog.domain.member.QMember.member
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Component

@Component
class MemberQueryRepository(
    private val queryFactory: JPAQueryFactory,
) {

    fun find(memberId: String): Member? {
        return queryFactory.select(member)
            .from(member)
            .where(member.memberId.eq(memberId))
            .fetchOne()
    }
}