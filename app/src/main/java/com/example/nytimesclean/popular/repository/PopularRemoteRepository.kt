package com.example.nytimesclean.popular.repository

import com.example.nytimesclean.popular.api.PopularArticleApi
import com.example.nytimesclean.popular.model.PopularArticle
import com.example.nytimesclean.popular.model.PopularArticleDataConverter
import com.example.nytimesclean.utils.Constants.API_KEY

class PopularRemoteRepository(
    private val api: PopularArticleApi
) : PopularRepository {
    override suspend fun getPopularArticles(page: Int): List<PopularArticle> {
        return PopularArticleDataConverter.fromNetwork(
            api.getMostPopular(API_KEY)
        )
    }
}