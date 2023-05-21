package com.example.nytimesclean.repositories.main_page_repos.db_repository

import com.example.nytimesclean.main_page.model.Article
import kotlinx.coroutines.flow.Flow

interface LocalArticleRepository {

    fun getAllLocalArticlesFlow(): Flow<List<Article>>

    suspend fun saveAllArticles(articles: List<Article>)
}