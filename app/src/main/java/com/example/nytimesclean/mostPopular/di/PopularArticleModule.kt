package com.example.nytimesclean.mostPopular.di

import com.example.nytimesclean.common.di.InjectionModule
import com.example.nytimesclean.mostPopular.api.repository.PopularRemoteRepository
import com.example.nytimesclean.mostPopular.api.repository.PopularRepository
import com.example.nytimesclean.mostPopular.db.repository.LocalPopularRepository
import com.example.nytimesclean.mostPopular.db.repository.PopularLocalRepository
import com.example.nytimesclean.mostPopular.interactor.PopularArticleInteractor
import com.example.nytimesclean.mostPopular.ui.PopularArticlePresenter
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module


object PopularArticleModule : InjectionModule {
    override fun create() = module {
        single {
            PopularRemoteRepository(get())
        } bind PopularRepository::class

        single {
            PopularLocalRepository(get())
        } bind LocalPopularRepository::class

        factoryOf(::PopularArticleInteractor)

        viewModelOf(::PopularArticlePresenter)
    }
}