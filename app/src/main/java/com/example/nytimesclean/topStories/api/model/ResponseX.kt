package com.example.nytimesclean.topStories.api.model


import com.google.gson.annotations.SerializedName

data class ResponseX(
    @SerializedName("docs")
    val docs: List<Doc>,
    @SerializedName("meta")
    val meta: Meta
)