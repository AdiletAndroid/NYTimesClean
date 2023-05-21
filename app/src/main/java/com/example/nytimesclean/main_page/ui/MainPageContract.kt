package com.example.nytimesclean.main_page.ui

import com.example.nytimesclean.common.mvp.MvpPresenter
import com.example.nytimesclean.common.mvp.MvpView
import com.example.nytimesclean.main_page.model.Article

interface MainPageContract {

    interface MainPageView : MvpView {
        fun showArticles(article: List<Article>)
    }

    interface MainPagePresenter: MvpPresenter<MainPageView> {
        fun getArticles(page: Int)
    }
}