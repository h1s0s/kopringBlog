package com.example.kopringBlog.domain.blog

import com.example.kopringBlog.common.BaseEntity
import com.example.kopringBlog.domain.category.Category
import com.example.kopringBlog.domain.member.Member
import javax.persistence.*

@Entity
class Blog(
    var title: String,
    var logoPath: String,

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val blogNo: Long? = null,

    @OneToMany
    @JoinColumn(name = "blog_no")
    val categories: MutableList<Category> = mutableListOf(),

    @OneToOne(mappedBy="blog")
    val member: Member? = null,
) : BaseEntity(){

    fun updateTitle(title: String){
        this.title = title
    }

    fun updateLogo(logoPath: String){
        this.logoPath = logoPath
    }
}