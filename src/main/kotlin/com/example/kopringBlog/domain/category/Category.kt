package com.example.kopringBlog.domain.category

import com.example.kopringBlog.common.BaseEntity
import com.example.kopringBlog.domain.post.Post
import javax.persistence.*

@Entity
class Category(
    val name: String,
    val description: String,

    @OneToMany
    @JoinColumn(name = "post_id")
    val posts: MutableList<Post> = mutableListOf(),

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val cateNo: Long? = null,
) : BaseEntity(){
}