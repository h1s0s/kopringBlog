package com.example.kopringBlog.controller

import com.example.kopringBlog.domain.user.User
import com.example.kopringBlog.dto.user.UserCreateRequest
import com.example.kopringBlog.dto.user.UserLoginRequest
import com.example.kopringBlog.service.user.UserService
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpSession

@Controller
class UserController(
    private val userService: UserService,
) {

    @GetMapping("/main")
    fun home(): String{
        return "main/home"
    }

    @GetMapping("/user/loginForm")
    fun loginForm(): String{
        return "user/loginForm"
    }

    @PostMapping("/users/login")
    fun login(@RequestBody request: UserLoginRequest, httpRequest : HttpServletRequest): String{
        val authUser = userService.getUser(request)
        return if(authUser != null){
            var session = httpRequest.session
            session.setAttribute("authUser", authUser)
            "redirect:/main"
        } else {
            "fail"
        }
    }

    @GetMapping("/user/joinForm")
    fun joinForm(): String{
        return "user/joinForm"
    }

    @PostMapping("/user/join")
    fun join(@RequestBody request: UserCreateRequest){
        userService.createUser(request)
    }

    @GetMapping("/user/joinSuccess")
    fun joinSuccess(): String{
        return "user/joinSuccess"
    }


}