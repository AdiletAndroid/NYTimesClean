package com.example.nytimesclean.main.api.model


import com.google.gson.annotations.SerializedName

data class KeywordResponse(
    @SerializedName("major")
    val major: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("rank")
    val rank: Int,
    @SerializedName("value")
    val value: String
)