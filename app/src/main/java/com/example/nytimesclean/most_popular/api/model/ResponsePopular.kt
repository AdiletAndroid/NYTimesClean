package com.example.nytimesclean.most_popular.api.model


import com.google.gson.annotations.SerializedName

data class ResponsePopular(
    @SerializedName("copyright")
    val copyright: String,
    @SerializedName("num_results")
    val numResults: Int,
    @SerializedName("results")
    val results: List<ResponseResult>,
    @SerializedName("status")
    val status: String
)