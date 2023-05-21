package com.example.nytimesclean.main.repository

import com.example.nytimesclean.main.db.dao.ArticleDao
import com.example.nytimesclean.main.db.model.ArticlesEntityConverter
import com.example.nytimesclean.main.model.Article
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