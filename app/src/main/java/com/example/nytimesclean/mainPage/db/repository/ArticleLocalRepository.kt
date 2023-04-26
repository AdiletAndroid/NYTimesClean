package com.example.nytimesclean.mainPage.db.repository

import com.example.nytimesclean.mainPage.db.dao.ArticleDao
import com.example.nytimesclean.mainPage.db.model.ArticlesEntityConverter
import com.example.nytimesclean.mainPage.model.Article
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