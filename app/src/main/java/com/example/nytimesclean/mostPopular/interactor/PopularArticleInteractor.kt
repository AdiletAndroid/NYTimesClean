package com.example.nytimesclean.mostPopular.interactor

import com.example.nytimesclean.mostPopular.api.repository.PopularRemoteRepository
import com.example.nytimesclean.mostPopular.db.repository.PopularLocalRepository
import com.example.nytimesclean.mostPopular.model.PopularArticle
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