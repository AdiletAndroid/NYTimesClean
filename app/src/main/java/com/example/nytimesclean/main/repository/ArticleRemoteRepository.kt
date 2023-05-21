package com.example.nytimesclean.main.repository

import com.example.nytimesclean.main.api.MainPageApi
import com.example.nytimesclean.main.model.Article
import com.example.nytimesclean.main.model.ArticleDataConverter
import com.example.nytimesclean.utils.Constants.API_KEY

class ArticleRemoteRepository(
    private val api: MainPageApi
) : ArticleRepository {
    override suspend fun getArticles(page: Int): List<Article> {
        return ArticleDataConverter.fromNetwork(api.getArticle(page, "q", API_KEY))
    }
}