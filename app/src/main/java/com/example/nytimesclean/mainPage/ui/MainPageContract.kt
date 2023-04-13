package com.example.nytimesclean.mainPage.ui

import com.example.nytimesclean.common.mvp.MvpPresenter
import com.example.nytimesclean.common.mvp.MvpView
import com.example.nytimesclean.mainPage.model.Article

interface MainPageContract {

    interface View : MvpView {
        fun showArticles(article: List<Article>)
    }

    interface Presenter: MvpPresenter<View> {
        fun getArticles(page: Int)
    }
}