package com.example.nytimesclean.main.ui.main

import com.example.nytimesclean.common.mvp.BasePresenter
import com.example.nytimesclean.main.interactor.MainPageInteractor
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.launch
import timber.log.Timber

class MainPagePresenter(
    private val interactor: MainPageInteractor
) : BasePresenter<MainPageContract.View>(),
    MainPageContract.Presenter {

    override fun getArticles(page: Int) {
        launch {
            try {
                view?.showLoading(isLoading = true)
                interactor.loadArticles(page)
            } catch (e: CancellationException) {
                Timber.e(e.message)
            } catch (t: Throwable) {
                Timber.e(t.message)
            } finally {
                view?.showLoading(isLoading = false)
            }
        }
    }

    override fun collectArticlesFlow() {
        launch {
            try {
                view?.showLoading(isLoading = true)
                interactor.getAllLocalArticlesFlow()
                    .collect() {
                        view?.showArticles(it)
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