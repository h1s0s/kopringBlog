package com.example.kopringBlog.service.blog

import com.example.kopringBlog.domain.blog.Blog
import com.example.kopringBlog.domain.blog.BlogRepository
import com.example.kopringBlog.dto.blog.BlogUpdateRequest
import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class BlogServiceTest @Autowired constructor(
    private val blogRepository: BlogRepository,
    private val blogService: BlogService,
) {

    @AfterEach
    fun clean(){
        blogRepository.deleteAll()
    }

    @Test
    @DisplayName("블로그명 수정 성공")
    fun updateTest(){
        //given
        val newBlog = Blog("테스트", "")
        blogRepository.save(newBlog)
        val request = BlogUpdateRequest.fixture("수정", null, newBlog.blogNo)

        //when
        blogService.updateTitle(request)

        //then
        val results = blogRepository.findAll()
        assertThat(results[0].title).isEqualTo(request.title)
    }
}