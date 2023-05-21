package com.example.nytimesclean.most_popular.db.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.nytimesclean.most_popular.db.model.EntityPopular


@Database(entities = [EntityPopular::class], version = 1, exportSchema = false)
abstract class PopularDatabase : RoomDatabase(){

    abstract fun popularDao(): PopularDao

}