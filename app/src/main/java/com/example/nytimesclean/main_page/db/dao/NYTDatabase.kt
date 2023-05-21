package com.example.nytimesclean.main_page.db.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.nytimesclean.main_page.db.model.EntityArticle

@Database(entities = [EntityArticle::class], version = 1, exportSchema = false)
abstract class NYTDatabase : RoomDatabase() {

    abstract fun articlesDao(): ArticleDao

}