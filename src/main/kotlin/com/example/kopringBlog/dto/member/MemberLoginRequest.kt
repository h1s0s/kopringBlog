package com.example.kopringBlog.dto.member

import com.example.kopringBlog.domain.blog.Blog
import com.example.kopringBlog.domain.user.Member
import com.example.kopringBlog.domain.user.MemberState

data class MemberLoginRequest(
    val memberId: String,
    val password: String,
) {

    companion object {
        fun fixture(
            memberId: String = "아이디",
            password: String = "비밀번호",
        ): MemberLoginRequest {
            return MemberLoginRequest(
                memberId = memberId,
                password = password,
            )
        }
    }
}