package com.example.kopringBlog.domain.user

import com.example.kopringBlog.domain.blog.Blog
import javax.persistence.*

@Entity
@Table(name="Users")
class User(
    val id: String,
    val password: String,

    @OneToOne @JoinColumn(name="blog_no")
    val blog: Blog,

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val userNo: Long? = null,
) {
}