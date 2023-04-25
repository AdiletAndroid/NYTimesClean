package com.example.nytimesclean.topStories.api.model


import com.google.gson.annotations.SerializedName

data class Response(
    @SerializedName("copyright")
    val copyright: String,
    @SerializedName("response")
    val response: ResponseX,
    @SerializedName("status")
    val status: String
)