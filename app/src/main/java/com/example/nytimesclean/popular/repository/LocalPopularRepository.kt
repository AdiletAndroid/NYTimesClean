package com.example.nytimesclean.popular.repository

import com.example.nytimesclean.popular.model.PopularArticle
import kotlinx.coroutines.flow.Flow

interface LocalPopularRepository {

    fun getLocalPopularFlow(): Flow<List<PopularArticle>>

    suspend fun saveAllPopular(popularArticles: List<PopularArticle>)
}