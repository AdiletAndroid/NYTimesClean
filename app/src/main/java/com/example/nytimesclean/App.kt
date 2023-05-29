package com.example.nytimesclean

import android.app.Application
import com.example.nytimesclean.common.di.CommonModule
import com.example.nytimesclean.main.di.ArticlesModule
import com.example.nytimesclean.popular.di.PopularArticleModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import timber.log.Timber

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        setupKoin()
        setupTimber()
    }

    private fun setupKoin() {
        stopKoin()
        startKoin {
            androidContext(this@App)
            modules(
                listOf(
                    CommonModule.create(),
                    ArticlesModule.create(),
                    PopularArticleModule.create()
                )
            )
        }
    }

    private fun setupTimber(){
        Timber.plant(Timber.DebugTree())
    }
}