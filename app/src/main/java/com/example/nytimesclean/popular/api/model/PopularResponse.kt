package com.example.nytimesclean.popular.api.model


import com.google.gson.annotations.SerializedName

data class PopularResponse(
    @SerializedName("copyright")
    val copyright: String,
    @SerializedName("num_results")
    val numResults: Int,
    @SerializedName("results")
    val results: List<ResultResponse>,
    @SerializedName("status")
    val status: String
)