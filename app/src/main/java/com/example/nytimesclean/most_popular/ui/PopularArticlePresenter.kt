package com.example.nytimesclean.most_popular.ui

import android.util.Log
import com.example.nytimesclean.common.mvp.BasePresenter
import com.example.nytimesclean.most_popular.interactor.PopularArticleInteractor
import kotlinx.coroutines.launch

class PopularArticlePresenter(
    private val popularInteractor: PopularArticleInteractor
) : BasePresenter<PopularArticleContract.PopularPageView>(), PopularArticleContract.PopularPagePresenter {

    override fun getPopular(page: Int) {
        launch {
            try {
                popularInteractor.loadPopular(page)
            } catch (e: Exception) {
                Log.e("popularArticles", "Error loading articles", e)
            }
        }
    }

    override fun attach(view: PopularArticleContract.PopularPageView) {
        super.attach(view)
        launch {
            popularInteractor.getAllPopularArticlesFlow()
                .collect() {
                    view.showPopular(it)
                }
        }
    }
}