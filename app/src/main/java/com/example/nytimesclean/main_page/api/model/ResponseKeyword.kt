package com.example.nytimesclean.main_page.api.model


import com.google.gson.annotations.SerializedName

data class ResponseKeyword(
    @SerializedName("major")
    val major: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("rank")
    val rank: Int,
    @SerializedName("value")
    val value: String
)