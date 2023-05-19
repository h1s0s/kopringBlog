package com.example.kopringBlog.controller.member

import com.example.kopringBlog.dto.member.MemberCreateRequest
import com.example.kopringBlog.dto.member.MemberLoginRequest
import com.example.kopringBlog.service.member.MemberService
import lombok.extern.slf4j.Slf4j
import org.json.JSONObject
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpSession

@Controller
@Slf4j
class MemberController(
    private val memberService: MemberService,
) {
    private val log = LoggerFactory.getLogger(MemberController::class.java)

    /**
     * 메인 페이지
     */
    @GetMapping("/main")
    fun home(): String{
        return "main/home"
    }

    /**
     * 로그인 페이지
     */
    @GetMapping("/member/loginForm")
    fun loginForm(): String{
        return "member/loginForm"
    }

    /**
     * 회원가입 페이지
     */
    @GetMapping("/member/joinForm")
    fun joinForm(): String{
        return "member/joinForm"
    }

    /**
     * 회원가입 성공 페이지
     */
    @GetMapping("/member/joinSuccess")
    fun joinSuccess(): String{
        return "member/joinSuccess"
    }
}
