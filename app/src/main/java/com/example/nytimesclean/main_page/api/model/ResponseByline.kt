package com.example.nytimesclean.main_page.api.model


import com.google.gson.annotations.SerializedName

data class ResponseByline(
    @SerializedName("organization")
    val organization: String,
    @SerializedName("original")
    val original: String,
    @SerializedName("person")
    val person: List<ResponsePerson>
)