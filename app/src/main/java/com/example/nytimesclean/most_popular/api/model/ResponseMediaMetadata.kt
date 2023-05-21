package com.example.nytimesclean.most_popular.api.model


import com.google.gson.annotations.SerializedName

data class ResponseMediaMetadata(
    @SerializedName("format")
    val format: String,
    @SerializedName("height")
    val height: Int,
    @SerializedName("url")
    val url: String,
    @SerializedName("width")
    val width: Int
)