package com.example.nytimesclean.main.di

import com.example.nytimesclean.common.di.InjectionModule
import com.example.nytimesclean.main.repository.ArticleRemoteRepository
import com.example.nytimesclean.main.repository.ArticleRepository
import com.example.nytimesclean.main.repository.ArticleLocalRepository
import com.example.nytimesclean.main.repository.LocalArticleRepository
import com.example.nytimesclean.main.interactor.MainPageInteractor
import com.example.nytimesclean.main.ui.main.MainPagePresenter
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

object ArticlesModule : InjectionModule {
    override fun create() = module {
        single {
            ArticleRemoteRepository(get())
        } bind ArticleRepository::class

        single {
            ArticleLocalRepository(get())
        } bind LocalArticleRepository::class

        factoryOf(::MainPageInteractor)

        viewModelOf(::MainPagePresenter)
    }
}