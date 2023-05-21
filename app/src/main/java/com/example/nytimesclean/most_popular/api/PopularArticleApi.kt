package com.example.nytimesclean.most_popular.api

import com.example.nytimesclean.most_popular.api.model.ResponsePopular
import com.example.nytimesclean.utils.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface PopularArticleApi {
    @GET("svc/mostpopular/v2/viewed/1.json")
    suspend fun getMostPopular(
        @Query("api-key") apiKey: String = API_KEY
    ): ResponsePopular
}