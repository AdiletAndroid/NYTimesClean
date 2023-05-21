package com.example.nytimesclean.popular.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.nytimesclean.popular.db.model.PopularEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PopularDao {

    @Query("SELECT * FROM popular")
    fun getAllPopularFlow(): Flow<List<PopularEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(popularEntity: List<PopularEntity>)
}