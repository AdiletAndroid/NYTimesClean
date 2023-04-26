package com.example.nytimesclean.mostPopular.api.repository

import com.example.nytimesclean.mostPopular.model.PopularArticle

interface PopularRepository {

    suspend fun getPopularArticles(page: Int): List<PopularArticle>

}