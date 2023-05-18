package com.example.kopringBlog.controller

import com.example.kopringBlog.dto.member.MemberCreateRequest
import com.example.kopringBlog.dto.member.MemberLoginRequest
import com.example.kopringBlog.service.member.MemberService
import lombok.extern.slf4j.Slf4j
import org.json.JSONObject
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import kotlin.math.log

@Controller
@Slf4j
class MemberController(
    private val userService: MemberService,
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

//    @PostMapping("/users/login")
//    fun login(@RequestBody request: UserLoginRequest, httpRequest : HttpServletRequest): String{
//        val authUser = userService.getMember(request)
//        return if(authUser != null){
//            var session = httpRequest.session
//            session.setAttribute("authUser", authUser)
//            "redirect:/main"
//        } else {
//            "fail"
//        }
//    }

    @GetMapping("/member/joinForm")
    fun joinForm(): String{
        return "member/joinForm"
    }

    @GetMapping("/member/idCheck")
    @ResponseBody
    fun idCheck(@RequestParam("memberId") memberId: String): JSONObject{
        val jsonObject = JSONObject()
        userService.getMember(memberId) ?: jsonObject.put("result","success")
        return jsonObject
    }

    @RequestMapping("/member/join")
    fun join(@RequestBody request: MemberCreateRequest): String{
        userService.createMember(request)
        return "redirect:/joinSuccess"
    }

    @GetMapping("/member/joinSuccess")
    fun joinSuccess(): String{
        return "member/joinSuccess"
    }
}
