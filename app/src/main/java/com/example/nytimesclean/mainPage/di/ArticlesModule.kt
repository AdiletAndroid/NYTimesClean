package com.example.nytimesclean.mainPage.di

import com.example.nytimesclean.common.di.InjectionModule
import com.example.nytimesclean.mainPage.api.repository.ArticleRemoteRepository
import com.example.nytimesclean.mainPage.api.repository.ArticleRepository
import com.example.nytimesclean.mainPage.db.repository.ArticleLocalRepository
import com.example.nytimesclean.mainPage.db.repository.LocalArticleRepository
import com.example.nytimesclean.mainPage.interactor.MainPageInteractor
import com.example.nytimesclean.mainPage.ui.MainPagePresenter
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
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