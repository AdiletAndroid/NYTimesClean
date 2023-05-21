package com.example.nytimesclean.main_page.api.model


import com.google.gson.annotations.SerializedName

data class ResponseResponseX(
    @SerializedName("docs")
    val docs: List<ResponseDoc>,
    @SerializedName("meta")
    val meta: ResponseMeta
)