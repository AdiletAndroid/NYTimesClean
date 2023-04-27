package com.example.nytimesclean.mostPopular.di

import com.example.nytimesclean.common.di.InjectionModule
import com.example.nytimesclean.mainPage.api.MainPageApi
import com.example.nytimesclean.mostPopular.api.PopularArticleApi
import com.example.nytimesclean.mostPopular.api.repository.PopularRemoteRepository
import com.example.nytimesclean.mostPopular.api.repository.PopularRepository
import com.example.nytimesclean.mostPopular.db.repository.LocalPopularRepository
import com.example.nytimesclean.mostPopular.db.repository.PopularLocalRepository
import com.example.nytimesclean.mostPopular.interactor.PopularArticleInteractor
import com.example.nytimesclean.mostPopular.ui.PopularArticlePresenter
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