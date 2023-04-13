package com.example.nytimesclean.mainPage.api.model


import com.google.gson.annotations.SerializedName

data class Byline(
    @SerializedName("organization")
    val organization: String,
    @SerializedName("original")
    val original: String,
    @SerializedName("person")
    val person: List<Person>
)