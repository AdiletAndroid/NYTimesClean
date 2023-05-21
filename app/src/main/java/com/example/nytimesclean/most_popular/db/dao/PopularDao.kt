package com.example.nytimesclean.most_popular.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.nytimesclean.most_popular.db.model.EntityPopular
import kotlinx.coroutines.flow.Flow

@Dao
interface PopularDao {

    @Query("SELECT * FROM popular")
    fun getAllPopularFlow(): Flow<List<EntityPopular>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(popularEntity: List<EntityPopular>)
}