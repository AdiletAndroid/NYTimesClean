package com.example.nytimesclean.mainPage.db.repository

import com.example.nytimesclean.mainPage.db.dao.ArticleDao
import com.example.nytimesclean.mainPage.db.model.ArticlesEnityConverter
import com.example.nytimesclean.mainPage.model.Article
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ArticleLocalRepository(
    private val dao: ArticleDao
) : LocalArticleRepository {
    override fun getAllLocalArticlesFlow(): Flow<List<Article>> {
        return dao.getAllArticlesFlow().map { entities ->
            ArticlesEnityConverter.fromEntity(entities)
        }
    }

    override suspend fun saveAllArticles(heroes: List<Article>) {
        val articleEntities = ArticlesEnityConverter.toEntity(heroes)
        dao.insert(articleEntities)
    }
}