package com.example.nytimesclean.mainPage.api

import com.example.nytimesclean.mainPage.api.model.ArticlesResponse
import com.example.nytimesclean.utils.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface MainPageApi {

    @GET("svc/search/v2/articlesearch.json")
    suspend fun getMostPopular(
        @Query("page") page: Int,
        @Query("q") query: String,
        @Query("apiKey") apiKey: String = API_KEY
    ): ArticlesResponse
}