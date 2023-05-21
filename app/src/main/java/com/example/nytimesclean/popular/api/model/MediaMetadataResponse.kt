package com.example.nytimesclean.popular.api.model


import com.google.gson.annotations.SerializedName

data class MediaMetadataResponse(
    @SerializedName("format")
    val format: String,
    @SerializedName("height")
    val height: Int,
    @SerializedName("url")
    val url: String,
    @SerializedName("width")
    val width: Int
)