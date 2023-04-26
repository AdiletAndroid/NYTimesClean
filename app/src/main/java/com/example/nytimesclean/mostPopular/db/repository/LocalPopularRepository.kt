package com.example.nytimesclean.mostPopular.db.repository

import com.example.nytimesclean.mostPopular.model.PopularArticle
import kotlinx.coroutines.flow.Flow

interface LocalPopularRepository {

    fun getLocalPopularFlow(): Flow<List<PopularArticle>>

    suspend fun saveAllPopular(popularArticles: List<PopularArticle>)
}