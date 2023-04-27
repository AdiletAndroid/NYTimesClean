package com.example.nytimesclean.detailsMostPopular

import com.example.nytimesclean.common.mvp.MvpView

interface MostPopularDetailsContract {

    interface PopularView : MvpView {
        fun showPopular()
    }
}