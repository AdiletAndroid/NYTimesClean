package com.example.nytimesclean.mainPage.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Article(
    val id: String,
//  val `abstract`: String,
    val documentType: String,
    val leadParagraph: String,
    val imageUrl: String,
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
) : Parcelable {
    fun getFormatedImageURL(): String? {
        if (imageUrl.isEmpty()) return null
        val prefix = "https://nytimes.com/"
        return prefix + imageUrl
    }
}