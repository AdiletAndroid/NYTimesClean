package com.example.nytimesclean.popular.ui.popular

import com.example.nytimesclean.common.mvp.MvpPresenter
import com.example.nytimesclean.common.mvp.MvpView
import com.example.nytimesclean.popular.model.PopularArticle

interface PopularArticleContract {

    interface PopularPageView : MvpView {
        fun showPopular(popularArticle: List<PopularArticle>)
    }

    interface PopularPagePresenter: MvpPresenter<PopularPageView> {
        fun getPopular(page: Int)

        fun collectPopularFlow()
    }
}