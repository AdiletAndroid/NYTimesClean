package com.example.nytimesclean.main_page.api.model


import com.google.gson.annotations.SerializedName

data class ResponseArticles(
    @SerializedName("copyright")
    val copyright: String,
    @SerializedName("response")
    val response: ResponseResponseX,
    @SerializedName("status")
    val status: String
)