package com.example.nytimesclean.popular.ui.popular

import com.example.nytimesclean.common.mvp.BasePresenter
import com.example.nytimesclean.popular.interactor.PopularArticleInteractor
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.launch
import timber.log.Timber

class PopularArticlePresenter(
    private val popularInteractor: PopularArticleInteractor
) : BasePresenter<PopularArticleContract.View>(),
    PopularArticleContract.Presenter {

    override fun getPopular(page: Int) {
        launch {
            try {
                view?.showLoading(isLoading = true)
                popularInteractor.loadPopular(page)
            } catch (e: CancellationException) {
                Timber.e(e.message)
            } catch (t: Throwable) {
                Timber.e(t.message)
            } finally {
                view?.showLoading(isLoading = false)
            }
        }
    }

    override fun collectPopularFlow() {
        launch {
            try {
                view?.showLoading(isLoading = true)
                popularInteractor.getAllPopularArticlesFlow()
                    .collect {
                        view?.showPopular(it)
                    }
            } catch (e: CancellationException) {
                Timber.e(e.message)
            } catch (t: Throwable) {
                Timber.e(t.message)
            } finally {
                view?.showLoading(isLoading = false)
            }
        }
    }
}