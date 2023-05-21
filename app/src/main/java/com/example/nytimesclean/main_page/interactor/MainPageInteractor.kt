package com.example.nytimesclean.main_page.interactor

import com.example.nytimesclean.repositories.main_page_repos.remote_repository.ArticleRepository
import com.example.nytimesclean.repositories.main_page_repos.db_repository.ArticleLocalRepository
import com.example.nytimesclean.main_page.model.Article
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