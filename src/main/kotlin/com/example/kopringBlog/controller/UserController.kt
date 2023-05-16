package com.example.kopringBlog.controller

import com.example.kopringBlog.domain.user.User
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class UserController {

    @GetMapping("/main")
    fun home(): String{
        return "main/home"
    }

    @GetMapping("/user/loginForm")
    fun loginForm(): String{
        return "user/loginForm"
    }

    @GetMapping("/user/joinForm")
    fun joinForm(): String{
        return "user/joinForm"
    }

    @PostMapping("/user/join")
    fun join(@RequestBody user: User){

    }

    @GetMapping("/user/joinSuccess")
    fun joinSuccess(): String{
        return "user/joinSuccess"
    }


}