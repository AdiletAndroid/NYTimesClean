package com.example.nytimesclean.mainPage.ui

import com.example.nytimesclean.common.mvp.MvpPresenter
import com.example.nytimesclean.common.mvp.MvpView
import com.example.nytimesclean.mainPage.model.Article

interface MainPageContract {

    interface MainPageView : MvpView {
        fun showArticles(article: List<Article>)
    }

    interface MainPagePresenter: MvpPresenter<MainPageView> {
        fun getArticles(page: Int)
    }
}