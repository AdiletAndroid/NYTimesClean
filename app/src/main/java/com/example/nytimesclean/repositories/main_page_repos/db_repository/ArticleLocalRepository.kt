package com.example.nytimesclean.repositories.main_page_repos.db_repository

import com.example.nytimesclean.main_page.db.dao.ArticleDao
import com.example.nytimesclean.main_page.db.model.ArticlesEntityConverter
import com.example.nytimesclean.main_page.model.Article
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ArticleLocalRepository(
    private val dao: ArticleDao
) : LocalArticleRepository {
    override fun getAllLocalArticlesFlow(): Flow<List<Article>> {
        return dao.getAllArticlesFlow().map { entities ->
            ArticlesEntityConverter.fromEntity(entities)
        }
    }

    override suspend fun saveAllArticles(articles: List<Article>) {
        val articleEntities = ArticlesEntityConverter.toEntity(articles)
        dao.insert(articleEntities)
    }
}