package com.example.nytimesclean.repositories.main_page_repos.remote_repository

import com.example.nytimesclean.main_page.api.MainPageApi
import com.example.nytimesclean.main_page.model.Article
import com.example.nytimesclean.main_page.model.ArticleDataConverter
import com.example.nytimesclean.utils.Constants.API_KEY

class ArticleRemoteRepository(
    private val api: MainPageApi
) : ArticleRepository {
    override suspend fun getArticles(page: Int): List<Article> {
        return ArticleDataConverter.fromNetwork(api.getArticle(page, "q", API_KEY))
    }
}