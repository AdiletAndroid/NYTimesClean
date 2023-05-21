package com.example.nytimesclean.main.repository

import com.example.nytimesclean.main.model.Article

interface ArticleRepository {
    suspend fun getArticles(page: Int): List<Article>
}