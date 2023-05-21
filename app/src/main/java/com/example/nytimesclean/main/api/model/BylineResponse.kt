package com.example.nytimesclean.main.api.model


import com.google.gson.annotations.SerializedName

data class BylineResponse(
    @SerializedName("organization")
    val organization: String,
    @SerializedName("original")
    val original: String,
    @SerializedName("person")
    val person: List<PersonResponse>
)