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

    @GetMapping("/main")
    fun home(): String{
        return "main/home"
    }

    @GetMapping("/member/loginForm")
    fun loginForm(): String{
        return "member/loginForm"
    }

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

    @GetMapping("/member/joinForm")
    fun joinForm(): String{
        return "member/joinForm"
    }

    @PostMapping("/member/idCheck")
    @ResponseBody
    fun idCheck(@RequestParam("memberId") memberId: String): Map<String, String>{
        val json : MutableMap<String, String> = mutableMapOf()
        memberService.getMember(memberId) ?: json.put("success", "true")
        return json
    }

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

    @GetMapping("/member/joinSuccess")
    fun joinSuccess(): String{
        return "member/joinSuccess"
    }
}
