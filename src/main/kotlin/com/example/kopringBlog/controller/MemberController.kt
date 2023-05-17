package com.example.kopringBlog.controller

import com.example.kopringBlog.dto.member.MemberCreateRequest
import com.example.kopringBlog.dto.member.MemberLoginRequest
import com.example.kopringBlog.service.member.MemberService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
class MemberController(
    private val userService: MemberService,
) {

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
    fun idCheck(@RequestParam("memberId") memberId: String): String{
        val user = userService.getMember(memberId)
        if(user == null){
            return "success"
        } else {
            return "fail"
        }
    }

    @PostMapping("/member/join")
    fun join(@RequestBody request: MemberCreateRequest){
        userService.createMember(request)
    }

    @GetMapping("/member/joinSuccess")
    fun joinSuccess(): String{
        return "member/joinSuccess"
    }


}