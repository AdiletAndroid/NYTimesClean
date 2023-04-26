package com.example.nytimesclean.mostPopular.ui

import com.example.nytimesclean.common.mvp.MvpPresenter
import com.example.nytimesclean.common.mvp.MvpView
import com.example.nytimesclean.mostPopular.model.PopularArticle

interface PopularArticleContract {

    interface PopularPageView : MvpView {
        fun showPopular(popularArticle: List<PopularArticle>)
    }

    interface PopularPagePresenter: MvpPresenter<PopularPageView> {
        fun getPopular(page: Int)
    }
}