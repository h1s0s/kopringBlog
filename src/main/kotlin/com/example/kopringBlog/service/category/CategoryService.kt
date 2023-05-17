package com.example.kopringBlog.service.category

import com.example.kopringBlog.domain.category.CategoryRepository
import org.springframework.stereotype.Service

@Service
class CategoryService(
    private val categoryRepository: CategoryRepository,
) {
}