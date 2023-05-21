package com.example.nytimesclean.main.ui.main

import com.example.nytimesclean.common.mvp.MvpPresenter
import com.example.nytimesclean.common.mvp.MvpView
import com.example.nytimesclean.main.model.Article

interface MainPageContract {

    interface MainPageView : MvpView {
        fun showArticles(article: List<Article>)
    }

    interface MainPagePresenter: MvpPresenter<MainPageView> {
        fun getArticles(page: Int)
    }
}