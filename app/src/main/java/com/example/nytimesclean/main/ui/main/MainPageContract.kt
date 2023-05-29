package com.example.nytimesclean.main.ui.main

import com.example.nytimesclean.common.mvp.MvpPresenter
import com.example.nytimesclean.common.mvp.MvpView
import com.example.nytimesclean.main.model.Article

interface MainPageContract {

    interface View : MvpView {
        fun showArticles(article: List<Article>)
        fun showLoading(isLoading: Boolean)

    }

    interface Presenter: MvpPresenter<View> {
        fun getArticles(page: Int)

        fun collectArticlesFlow()
    }
}