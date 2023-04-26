package com.example.nytimesclean.mostPopular.db.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.nytimesclean.mostPopular.db.model.PopularEntity


@Database(entities = [PopularEntity::class], version = 1, exportSchema = false)
abstract class PopularDatabase : RoomDatabase(){

    abstract fun popularDao(): PopularDao

}