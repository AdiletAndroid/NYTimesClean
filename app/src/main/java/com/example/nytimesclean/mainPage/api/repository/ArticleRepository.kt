package com.example.nytimesclean.mainPage.api.repository

import com.example.nytimesclean.mainPage.model.Article

interface ArticleRepository {
    suspend fun getArticles(page: Int): List<Article>
}