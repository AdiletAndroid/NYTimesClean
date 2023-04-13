package com.example.nytimesclean.mainPage.db.repository

import com.example.nytimesclean.mainPage.model.Article
import kotlinx.coroutines.flow.Flow

interface LocalArticleRepository {

    fun getAllLocalArticlesFlow(): Flow<List<Article>>

    suspend fun saveAllArticles(heroes: List<Article>)
}