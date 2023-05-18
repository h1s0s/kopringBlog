package com.example.kopringBlog.dto.member

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