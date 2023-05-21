package com.example.nytimesclean.most_popular.interactor

import com.example.nytimesclean.repositories.most_popular_repos.remote_repository.PopularRemoteRepository
import com.example.nytimesclean.repositories.most_popular_repos.db_repository.PopularLocalRepository
import com.example.nytimesclean.most_popular.model.PopularArticle
import kotlinx.coroutines.flow.Flow

class PopularArticleInteractor (
    private val repository: PopularRemoteRepository,
    private val localRepository: PopularLocalRepository
) {
    suspend fun loadPopular(page: Int) {
        val popularArticles = repository.getPopularArticles(page)
        localRepository.saveAllPopular(popularArticles)
    }

    fun getAllPopularArticlesFlow(): Flow<List<PopularArticle>> {
        return localRepository.getLocalPopularFlow()
    }
}