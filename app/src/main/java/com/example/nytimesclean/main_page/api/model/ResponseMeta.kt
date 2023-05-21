package com.example.nytimesclean.main_page.api.model


import com.google.gson.annotations.SerializedName

data class ResponseMeta(
    @SerializedName("hits")
    val hits: Int,
    @SerializedName("offset")
    val offset: Int,
    @SerializedName("time")
    val time: Int
)