package com.example.nytimesclean.main.interactor

import com.example.nytimesclean.main.repository.ArticleRepository
import com.example.nytimesclean.main.repository.ArticleLocalRepository
import com.example.nytimesclean.main.model.Article
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