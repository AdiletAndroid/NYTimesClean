package com.example.nytimesclean.main_page.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.nytimesclean.main_page.db.model.EntityArticle
import kotlinx.coroutines.flow.Flow

@Dao
interface ArticleDao {
    @Query("SELECT * FROM articles")
    fun getAllArticlesFlow(): Flow<List<EntityArticle>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(articleEntity: List<EntityArticle>)

}