package com.example.nytimesclean.mainPage.api.model


import com.google.gson.annotations.SerializedName

data class ArticlesResponse(
    @SerializedName("copyright")
    val copyright: String,
    @SerializedName("response")
    val response: ResponseX,
    @SerializedName("status")
    val status: String
)