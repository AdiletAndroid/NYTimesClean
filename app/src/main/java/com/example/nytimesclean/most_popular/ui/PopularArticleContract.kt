package com.example.nytimesclean.most_popular.ui

import com.example.nytimesclean.common.mvp.MvpPresenter
import com.example.nytimesclean.common.mvp.MvpView
import com.example.nytimesclean.most_popular.model.PopularArticle

interface PopularArticleContract {

    interface PopularPageView : MvpView {
        fun showPopular(popularArticle: List<PopularArticle>)
    }

    interface PopularPagePresenter: MvpPresenter<PopularPageView> {
        fun getPopular(page: Int)
    }
}