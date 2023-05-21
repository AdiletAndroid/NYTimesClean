package com.example.nytimesclean.common.di

import androidx.room.Room
import com.example.nytimesclean.main_page.api.MainPageApi
import com.example.nytimesclean.main_page.db.dao.NYTDatabase
import com.example.nytimesclean.most_popular.db.dao.PopularDatabase
import com.example.nytimesclean.utils.Constants.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CommonModule : InjectionModule {

    override fun create() = module {
        single {
            Retrofit.Builder().baseUrl(BASE_URL)
                .client(get())
                .addConverterFactory(GsonConverterFactory.create()).build()
                .create(MainPageApi::class.java)
        }
        single {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build()
        }

        single {
            Room.databaseBuilder(
                androidApplication(),
                NYTDatabase::class.java,
                "database"
            ).build()
        }

        single {
            val database = get<NYTDatabase>()
            database.articlesDao()
        }

        single {
            Room.databaseBuilder(
                androidApplication(),
                PopularDatabase::class.java,
                "popularDatabase"
            ).build()
        }

        single {
            val database = get<PopularDatabase>()
            database.popularDao()
        }
    }
}