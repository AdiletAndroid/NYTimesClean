package com.example.nytimesclean.repositories.most_popular_repos.remote_repository

import com.example.nytimesclean.most_popular.api.PopularArticleApi
import com.example.nytimesclean.most_popular.model.PopularArticle
import com.example.nytimesclean.most_popular.model.PopularArticleDataConverter
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