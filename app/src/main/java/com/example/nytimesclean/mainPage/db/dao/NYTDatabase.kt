package com.example.nytimesclean.mainPage.db.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.nytimesclean.mainPage.db.model.ArticleEntity

@Database(entities = [ArticleEntity::class], version = 1, exportSchema = false)
abstract class NYTDatabase : RoomDatabase() {

    abstract fun articlesDao(): ArticleDao

}