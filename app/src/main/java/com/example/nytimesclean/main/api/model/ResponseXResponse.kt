package com.example.nytimesclean.main.api.model


import com.google.gson.annotations.SerializedName

data class ResponseXResponse(
    @SerializedName("docs")
    val docs: List<DocResponse>,
    @SerializedName("meta")
    val meta: MetaResponse
)