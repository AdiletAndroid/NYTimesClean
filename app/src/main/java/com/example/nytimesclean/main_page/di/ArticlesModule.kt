package com.example.nytimesclean.main_page.di

import com.example.nytimesclean.common.di.InjectionModule
import com.example.nytimesclean.repositories.main_page_repos.remote_repository.ArticleRemoteRepository
import com.example.nytimesclean.repositories.main_page_repos.remote_repository.ArticleRepository
import com.example.nytimesclean.repositories.main_page_repos.db_repository.ArticleLocalRepository
import com.example.nytimesclean.repositories.main_page_repos.db_repository.LocalArticleRepository
import com.example.nytimesclean.main_page.interactor.MainPageInteractor
import com.example.nytimesclean.main_page.ui.MainPagePresenter
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