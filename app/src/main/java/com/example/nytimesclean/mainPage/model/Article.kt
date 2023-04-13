package com.example.nytimesclean.mainPage.model

import android.os.Parcelable
import com.example.nytimesclean.mainPage.api.model.Byline
import com.example.nytimesclean.mainPage.api.model.Headline
import com.example.nytimesclean.mainPage.api.model.Keyword
import com.example.nytimesclean.mainPage.api.model.Multimedia
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Article(
    val `abstract`: String,
    val documentType: String,
    val id: String,
    val leadParagraph: String,
    val imageUrl : String,
    val newsDesk: String,
    val pubDate: String,
    val sectionName: String,
    val snippet: String,
    val source: String,
    val subsectionName: String,
    val typeOfMaterial: String,
    val uri: String,
    val webUrl: String,
    val wordCount: Int
) : Parcelable