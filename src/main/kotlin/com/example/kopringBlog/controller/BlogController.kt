package com.example.kopringBlog.controller

import com.example.kopringBlog.service.blog.BlogService
import lombok.extern.slf4j.Slf4j
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@Controller
@Slf4j
class BlogController(
    private val blogService: BlogService,
) {

    @GetMapping("/blog/{memberId}")
    fun blog(@PathVariable("memberId") memberId: String): String{
        blogService.getBlog(memberId)
        return "blog/blog-main"
    }
}