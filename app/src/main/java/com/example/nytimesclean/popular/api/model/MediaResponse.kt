package com.example.nytimesclean.popular.api.model


import com.google.gson.annotations.SerializedName

data class MediaResponse(
    @SerializedName("approved_for_syndication")
    val approvedForSyndication: Int,
    @SerializedName("caption")
    val caption: String,
    @SerializedName("copyright")
    val copyright: String,
    @SerializedName("media-metadata")
    val mediaMetadata: List<MediaMetadataResponse>,
    @SerializedName("subtype")
    val subtype: String,
    @SerializedName("type")
    val type: String
)