package com.example.nytimesclean.main.ui.main

import android.util.Log
import com.example.nytimesclean.common.mvp.BasePresenter
import com.example.nytimesclean.main.interactor.MainPageInteractor
import kotlinx.coroutines.launch

class MainPagePresenter(
    private val interactor: MainPageInteractor
) : BasePresenter<MainPageContract.MainPageView>(),
    MainPageContract.MainPagePresenter {

    override fun getArticles(page: Int) {
        launch {
            try {
                interactor.loadArticles(page)
            } catch (e: Exception) {
                Log.e("articles", "Error loading articles", e)
            }

        }
    }

    override fun collectArticlesFlow() {
        launch {
            interactor.getAllLocalArticlesFlow()
                .collect() {
                    view?.showArticles(it)
                }
        }
    }
}