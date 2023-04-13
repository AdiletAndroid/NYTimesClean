package com.example.nytimesclean.mainPage.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "articles")
data class ArticleEntity(
    @PrimaryKey
    @ColumnInfo("articleId")
    val id: String,
    @ColumnInfo("abstract")
    val `abstract`: String,
    @ColumnInfo("documentType")
    val documentType: String,
    @ColumnInfo("leadParagraph")
    val leadParagraph: String,
    @ColumnInfo("imageUrl")
    val imageUrl: String,
    @ColumnInfo("newsDesk")
    val newsDesk: String,
    @ColumnInfo("pubDate")
    val pubDate: String,
    @ColumnInfo("sectionName")
    val sectionName: String,
    @ColumnInfo("snippet")
    val snippet: String,
    @ColumnInfo("source")
    val source: String,
    @ColumnInfo("subsectionName")
    val subsectionName: String,
    @ColumnInfo("typeOfMaterial")
    val typeOfMaterial: String,
    @ColumnInfo("uri")
    val uri: String,
    @ColumnInfo("webUrl")
    val webUrl: String,
    @ColumnInfo("wordCount")
    val wordCount: Int
)