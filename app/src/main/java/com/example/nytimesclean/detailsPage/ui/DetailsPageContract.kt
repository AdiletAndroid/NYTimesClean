package com.example.nytimesclean.detailsPage.ui

import com.example.nytimesclean.common.mvp.MvpView

interface DetailsPageContract {
    interface View : MvpView {
        fun showArticle()
    }
}