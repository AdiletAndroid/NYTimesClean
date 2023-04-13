package com.example.nytimesclean.mainPage.interactor

import com.example.nytimesclean.mainPage.api.repository.ArticleRepository
import com.example.nytimesclean.mainPage.db.repository.ArticleLocalRepository
import com.example.nytimesclean.mainPage.model.Article
import kotlinx.coroutines.flow.Flow

class MainPageInteractor(
    private val repository: ArticleRepository,
    private val localRepository: ArticleLocalRepository
) {
    suspend fun loadArticles(page: Int) {
        val articles = repository.getArticles(page)
        localRepository.saveAllArticles(articles)
    }

    fun getAllLocalArticlesFlow(): Flow<List<Article>> {
        return localRepository.getAllLocalArticlesFlow()
    }
}