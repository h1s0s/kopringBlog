package com.example.kopringBlog.domain.member

import com.example.kopringBlog.common.BaseEntity
import com.example.kopringBlog.domain.blog.Blog
import javax.persistence.*

@Entity
@Table(name="Member")
class Member(
    val memberId: String,
    var password: String,
    var memberName: String,
    var state: MemberState = MemberState.NORMAL,

    @OneToOne @JoinColumn(name="blog_no")
    val blog: Blog? = null,

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val memberNo: Long? = null,
) : BaseEntity(){
    companion object {
        fun fixture(
            memberId: String = "아이디",
            password: String = "비밀번호",
            memberName: String ="이름",
            state: MemberState = MemberState.NORMAL,
            blog: Blog? = null,
            memberNo: Long? = null
        ): Member {
            return Member(
                memberId = memberId,
                password = password,
                memberName = memberName,
                state = state,
                blog = blog,
                memberNo = memberNo,
            )
        }
    }

    fun stateToDeleted(){
        this.state = MemberState.DELETED
    }
}