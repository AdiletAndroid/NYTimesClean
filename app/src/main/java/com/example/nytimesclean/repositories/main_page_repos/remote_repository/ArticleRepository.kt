package com.example.nytimesclean.repositories.main_page_repos.remote_repository

import com.example.nytimesclean.main_page.model.Article

interface ArticleRepository {
    suspend fun getArticles(page: Int): List<Article>
}