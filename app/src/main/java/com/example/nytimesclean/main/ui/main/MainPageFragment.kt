package com.example.nytimesclean.main.ui.main

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nytimesclean.R
import com.example.nytimesclean.common.mvp.BaseMvpFragment
import com.example.nytimesclean.databinding.FragmentMainPageBinding
import com.example.nytimesclean.details_main.MainPageDetailsFragment
import com.example.nytimesclean.main.model.Article
import com.example.nytimesclean.main.ui.main.adapter.ArticlesAdapter
import com.example.nytimesclean.utils.extantions.replaceFragment
import com.example.nytimesclean.utils.extantions.viewbinding.viewBinding
import org.koin.android.ext.android.inject

class MainPageFragment :
    BaseMvpFragment<MainPageContract.View, MainPageContract.Presenter>(R.layout.fragment_main_page),
    MainPageContract.View {

    private val binding: FragmentMainPageBinding by viewBinding()

    override val presenter: MainPagePresenter by inject()

    private val adapter: ArticlesAdapter by lazy {
        ArticlesAdapter { article ->
            openDetailsPage(article)
        }
    }

    private val layoutManager: LinearLayoutManager by lazy {
        LinearLayoutManager(requireContext())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            recyclerView.layoutManager = layoutManager
            recyclerView.adapter = adapter
        }
        presenter.getArticles(1)
        presenter.collectArticlesFlow()
    }

    override fun showArticles(article: List<Article>) {
        adapter.updateList(article)
    }

    override fun showLoading(isLoading: Boolean) {
        with(binding) {
            progressBar.isVisible = isLoading
            recyclerView.isVisible = !isLoading
        }
    }

    private fun openDetailsPage(article: Article) {
        val fragment = MainPageDetailsFragment.create(article)
        replaceFragment(fragment)
    }
}