package com.example.nytimesclean.main.repository

import com.example.nytimesclean.main.model.Article
import kotlinx.coroutines.flow.Flow

interface LocalArticleRepository {

    fun getAllLocalArticlesFlow(): Flow<List<Article>>

    suspend fun saveAllArticles(articles: List<Article>)
}