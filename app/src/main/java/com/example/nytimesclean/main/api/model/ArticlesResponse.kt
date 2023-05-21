package com.example.nytimesclean.main.api.model


import com.google.gson.annotations.SerializedName

data class ArticlesResponse(
    @SerializedName("copyright")
    val copyright: String,
    @SerializedName("response")
    val response: ResponseXResponse,
    @SerializedName("status")
    val status: String
)