package com.example.nytimesclean.popular.ui.popular

import com.example.nytimesclean.common.mvp.MvpPresenter
import com.example.nytimesclean.common.mvp.MvpView
import com.example.nytimesclean.popular.model.PopularArticle

interface PopularArticleContract {

    interface View : MvpView {
        fun showPopular(popularArticle: List<PopularArticle>)
        fun showLoading(isLoading: Boolean)
    }

    interface Presenter : MvpPresenter<View> {
        fun getPopular(page: Int)

        fun collectPopularFlow()
    }
}