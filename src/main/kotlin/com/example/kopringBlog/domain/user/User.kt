package com.example.kopringBlog.domain.user

import com.example.kopringBlog.domain.blog.Blog
import javax.persistence.*

@Entity
@Table(name="Users")
class User(
    val id: String,
    val password: String,

    @OneToOne @JoinColumn(name="blog_no")
    val blog: Blog? = null,

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val userNo: Long? = null,
) {
    companion object {
        fun fixture(
            id: String = "아이디",
            password: String = "비밀번호",
            blog: Blog? = null,
            userNo: Long? = null
        ): User {
            return User(
                id = id,
                password = password,
                blog = blog,
                userNo = userNo,
            )
        }
    }
}