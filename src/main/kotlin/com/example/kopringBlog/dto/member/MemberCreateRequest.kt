package com.example.kopringBlog.dto.member

data class MemberCreateRequest(
    val memberId: String,
    val password: String,
    val memberName: String,
) {
}