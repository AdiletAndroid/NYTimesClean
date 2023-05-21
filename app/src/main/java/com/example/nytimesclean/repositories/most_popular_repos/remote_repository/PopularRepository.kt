package com.example.nytimesclean.repositories.most_popular_repos.remote_repository

import com.example.nytimesclean.most_popular.model.PopularArticle

interface PopularRepository {

    suspend fun getPopularArticles(page: Int): List<PopularArticle>

}