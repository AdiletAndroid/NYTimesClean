package com.example.nytimesclean.topStories.api.model


import com.google.gson.annotations.SerializedName

data class Keyword(
    @SerializedName("major")
    val major: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("rank")
    val rank: Int,
    @SerializedName("value")
    val value: String
)