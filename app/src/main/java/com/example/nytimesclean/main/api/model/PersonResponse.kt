package com.example.nytimesclean.main.api.model


import com.google.gson.annotations.SerializedName

data class PersonResponse(
    @SerializedName("firstname")
    val firstname: String,
    @SerializedName("lastname")
    val lastname: String,
    @SerializedName("middlename")
    val middlename: String,
    @SerializedName("organization")
    val organization: String,
    @SerializedName("qualifier")
    val qualifier: Any,
    @SerializedName("rank")
    val rank: Int,
    @SerializedName("role")
    val role: String,
    @SerializedName("title")
    val title: Any
)