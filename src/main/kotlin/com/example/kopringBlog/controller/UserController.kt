package com.example.kopringBlog.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class UserController {

    @GetMapping("/main")
    fun home(): String{
        return "main/home"
    }

}