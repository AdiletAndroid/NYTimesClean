package com.example.nytimesclean.mostPopular.api.repository

import com.example.nytimesclean.mostPopular.api.PopularArticleApi
import com.example.nytimesclean.mostPopular.model.PopularArticle
import com.example.nytimesclean.mostPopular.model.PopularArticleDataConverter
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