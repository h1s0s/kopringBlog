package com.example.kopringBlog.dto.blog

data class BlogUpdateRequest(
    val title: String,
    val logoPath: String?,
    val blogNo: Long?,
) {
    companion object {
        fun fixture(
            title: String = "블로그명",
            logoPath: String? = null,
            blogNo: Long? = null,
        ): BlogUpdateRequest {
            return BlogUpdateRequest(
                blogNo = blogNo,
                title = title,
                logoPath = logoPath
            )
        }
    }
}