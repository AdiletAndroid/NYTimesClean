package com.example.nytimesclean.mainPage.api.repository

import com.example.nytimesclean.mainPage.api.MainPageApi
import com.example.nytimesclean.mainPage.model.Article
import com.example.nytimesclean.mainPage.model.ArticleDataConverter
import com.example.nytimesclean.utils.Constants.API_KEY

class ArticleRemoteRepository(
    private val api: MainPageApi
) : ArticleRepository {
    override suspend fun getArticles(page: Int): List<Article> {
        return ArticleDataConverter.fromNetwork(api.getArticle(page, "q", API_KEY))
    }
}