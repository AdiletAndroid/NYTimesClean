package com.example.nytimesclean.popular.ui.popular

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nytimesclean.R
import com.example.nytimesclean.common.mvp.BaseMvpFragment
import com.example.nytimesclean.databinding.FragmentPopularArticleBinding
import com.example.nytimesclean.details_popular.PopularDetailsFragment
import com.example.nytimesclean.popular.model.PopularArticle
import com.example.nytimesclean.popular.ui.popular.adapter.PopularAdapter
import com.example.nytimesclean.utils.extantions.replaceFragment
import com.example.nytimesclean.utils.extantions.viewbinding.viewBinding
import org.koin.android.ext.android.inject

class PopularArticleFragment :
    BaseMvpFragment<PopularArticleContract.View, PopularArticleContract.Presenter>(
        R.layout.fragment_popular_article
    ), PopularArticleContract.View {

    override val presenter: PopularArticlePresenter by inject()

    private val binding: FragmentPopularArticleBinding by viewBinding()

    private val popularAdapter: PopularAdapter by lazy {
        PopularAdapter { popularArticle ->
            openDetailsPage(popularArticle)
        }
    }

    private val layoutManager: LinearLayoutManager by lazy {
        LinearLayoutManager(requireContext())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            recyclerView.layoutManager = layoutManager
            recyclerView.adapter = popularAdapter
        }
        presenter.getPopular(1)
        presenter.collectPopularFlow()
    }

    private fun openDetailsPage(popularArticle: PopularArticle) {
        val fragment = PopularDetailsFragment.create(popularArticle)
        replaceFragment(fragment)
    }

    override fun showPopular(popularArticle: List<PopularArticle>) {
        popularAdapter.updateList(popularArticle)
    }

    override fun showLoading(isLoading: Boolean) {
        with(binding) {
            progressBar.isVisible = isLoading
            recyclerView.isVisible = !isLoading
        }
    }
}