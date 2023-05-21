package com.example.nytimesclean.repositories.most_popular_repos.db_repository

import com.example.nytimesclean.most_popular.db.dao.PopularDao
import com.example.nytimesclean.most_popular.db.model.PopularEntityConverter
import com.example.nytimesclean.most_popular.model.PopularArticle
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class PopularLocalRepository(
    private val dao: PopularDao
) : LocalPopularRepository {
    override fun getLocalPopularFlow(): Flow<List<PopularArticle>> {
        return dao.getAllPopularFlow().map { entities ->
            PopularEntityConverter.fromEntity(entities)
        }
    }

    override suspend fun saveAllPopular(popularArticles: List<PopularArticle>) {
        val popularEntities = PopularEntityConverter.toEntity(popularArticles)
        dao.insert(popularEntities)
    }
}