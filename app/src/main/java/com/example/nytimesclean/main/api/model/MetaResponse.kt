package com.example.nytimesclean.main.api.model


import com.google.gson.annotations.SerializedName

data class MetaResponse(
    @SerializedName("hits")
    val hits: Int,
    @SerializedName("offset")
    val offset: Int,
    @SerializedName("time")
    val time: Int
)