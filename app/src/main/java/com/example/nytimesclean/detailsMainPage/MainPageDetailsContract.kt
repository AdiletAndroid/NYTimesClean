package com.example.nytimesclean.detailsMainPage

import com.example.nytimesclean.common.mvp.MvpView

interface MainPageDetailsContract {
    interface View : MvpView {
        fun showArticle()
    }
}