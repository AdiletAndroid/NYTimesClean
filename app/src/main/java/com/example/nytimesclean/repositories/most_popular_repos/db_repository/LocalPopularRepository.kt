package com.example.nytimesclean.repositories.most_popular_repos.db_repository

import com.example.nytimesclean.most_popular.model.PopularArticle
import kotlinx.coroutines.flow.Flow

interface LocalPopularRepository {

    fun getLocalPopularFlow(): Flow<List<PopularArticle>>

    suspend fun saveAllPopular(popularArticles: List<PopularArticle>)
}