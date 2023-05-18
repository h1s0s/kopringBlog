package com.example.kopringBlog.controller

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
import kotlin.math.log

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
     * 로그인
     */
    @PostMapping("/member/login")
    fun login(@ModelAttribute request: MemberLoginRequest, httpRequest : HttpServletRequest, jsonObject : JSONObject): JSONObject{
        val authUser = memberService.getMember(request.memberId)
        if(authUser != null){
            var session: HttpSession = httpRequest.session
            session.setAttribute("authUser", authUser)
            jsonObject.put("authUser", authUser)
        }
        return jsonObject
    }

    /**
     * 회원가입 페이지
     */
    @GetMapping("/member/joinForm")
    fun joinForm(): String{
        return "member/joinForm"
    }

    /**
     * ID 중복 체크
     */
    @PostMapping("/member/idCheck")
    @ResponseBody
    fun idCheck(@RequestParam("memberId") memberId: String): Map<String, String>{
        val json : MutableMap<String, String> = mutableMapOf()
        memberService.getMember(memberId) ?: json.put("success", "true")
        return json
    }

    /**
     * 회원가입
     */
    @PostMapping("/member/join")
    @ResponseBody
    fun join(@ModelAttribute request: MemberCreateRequest): Map<String, Boolean>{
        val json : MutableMap<String, Boolean> = mutableMapOf()
        try {
            memberService.createMember(request)
            json["success"] = true
        } catch(e: Exception){
            json["success"] = false
        }
        return json
    }

    /**
     * 회원가입 성공 페이지
     */
    @GetMapping("/member/joinSuccess")
    fun joinSuccess(): String{
        return "member/joinSuccess"
    }
}
