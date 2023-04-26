package com.example.nytimesclean.mostPopular.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PopularArticle(
    val id: Long,
    val assetId: Long,
    val adxKeywords: String,
    val byline: String,
    val column: String,
    val etaId: Int,
    val nytdsection: String,
    val publishedDate: String,
    val section: String,
    val source: String,
    val subsection: String,
    val title: String,
    val type: String,
    val updated: String,
    val uri: String,
    val url: String
) : Parcelable