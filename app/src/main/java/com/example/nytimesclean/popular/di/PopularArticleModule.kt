package com.example.nytimesclean.popular.di

import com.example.nytimesclean.common.di.InjectionModule
import com.example.nytimesclean.popular.api.PopularArticleApi
import com.example.nytimesclean.popular.repository.PopularRemoteRepository
import com.example.nytimesclean.popular.repository.PopularRepository
import com.example.nytimesclean.popular.repository.LocalPopularRepository
import com.example.nytimesclean.popular.repository.PopularLocalRepository
import com.example.nytimesclean.popular.interactor.PopularArticleInteractor
import com.example.nytimesclean.popular.ui.popular.PopularArticlePresenter
import com.example.nytimesclean.utils.Constants
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object PopularArticleModule : InjectionModule {
    override fun create() = module {
        single {
            Retrofit.Builder().baseUrl(Constants.BASE_URL)
                .client(get())
                .addConverterFactory(GsonConverterFactory.create()).build()
                .create(PopularArticleApi::class.java)
        }
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