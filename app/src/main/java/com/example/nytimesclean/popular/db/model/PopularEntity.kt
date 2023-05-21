package com.example.nytimesclean.popular.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "popular")
data class PopularEntity (
    @PrimaryKey
    @ColumnInfo("popularId")
    val id: Long,
    @ColumnInfo("assetId")
    val assetId: Long,
    @ColumnInfo("adxKeywords")
    val adxKeywords: String,
    @ColumnInfo("byline")
    val byline: String,
    @ColumnInfo("column")
    val column: String,
    @ColumnInfo("etaId")
    val etaId: Int,
    @ColumnInfo("nytdsection")
    val nytdsection: String,
    @ColumnInfo("publishedDate")
    val publishedDate: String,
    @ColumnInfo("section")
    val section: String,
    @ColumnInfo("source")
    val source: String,
    @ColumnInfo("subsection")
    val subsection: String,
    @ColumnInfo("title")
    val title: String,
    @ColumnInfo("type")
    val type: String,
    @ColumnInfo("updated")
    val updated: String,
    @ColumnInfo("uri")
    val uri: String,
    @ColumnInfo("url")
    val url: String
)