package com.example.kopringBlog.controller.blog

import com.example.kopringBlog.service.blog.BlogService
import lombok.extern.slf4j.Slf4j
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@Controller
@Slf4j
class BlogController(
    private val blogService: BlogService,
) {

    /**
     * 블로그 메인 페이지
     */
    @GetMapping("/blog/{memberId}")
    fun blog(@PathVariable("memberId") memberId: String, model: Model): String{
        val blog = blogService.getBlog(memberId)
        model.addAttribute("blog", blog)
        return "blog/blog-main"
    }
}