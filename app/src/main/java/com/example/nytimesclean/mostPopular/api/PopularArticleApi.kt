package com.example.nytimesclean.mostPopular.api

import com.example.nytimesclean.mostPopular.api.model.PopularResponse
import com.example.nytimesclean.utils.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface PopularArticleApi {
    @GET("svc/mostpopular/v2/viewed/1.json")
    suspend fun getMostPopular(
        @Query("api-key") apiKey: String = API_KEY
    ): PopularResponse
}