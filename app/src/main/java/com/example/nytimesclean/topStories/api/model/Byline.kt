package com.example.nytimesclean.topStories.api.model


import com.google.gson.annotations.SerializedName

data class Byline(
    @SerializedName("organization")
    val organization: Any,
    @SerializedName("original")
    val original: String,
    @SerializedName("person")
    val person: List<Person>
)