package com.example.nytimesclean.popular.repository

import com.example.nytimesclean.popular.model.PopularArticle

interface PopularRepository {

    suspend fun getPopularArticles(page: Int): List<PopularArticle>

}