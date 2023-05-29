package com.example.nytimesclean.popular.ui.popular

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nytimesclean.R
import com.example.nytimesclean.common.mvp.BaseMvpFragment
import com.example.nytimesclean.common.ui.endlessScroll.EndlessScrollListener
import com.example.nytimesclean.databinding.FragmentPopularArticleBinding
import com.example.nytimesclean.details_popular.PopularDetailsFragment
import com.example.nytimesclean.popular.model.PopularArticle
import com.example.nytimesclean.popular.ui.popular.adapter.PopularAdapter
import com.example.nytimesclean.utils.replaceFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class PopularArticleFragment :
    BaseMvpFragment<PopularArticleContract.PopularPageView, PopularArticleContract.PopularPagePresenter>(
        R.layout.fragment_popular_article
    ),
    PopularArticleContract.PopularPageView {

    override val presenter: PopularArticlePresenter by viewModel()
    private lateinit var binding: FragmentPopularArticleBinding
    private val popularAdapter: PopularAdapter by lazy {
        PopularAdapter { popularArticle ->
            openDetailsPage(popularArticle)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPopularArticleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setContent()
        presenter.getPopular(1)
        presenter.collectPopularFlow()
    }

    private fun setContent() {
        val layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = popularAdapter
        val scrollListener = EndlessScrollListener(layoutManager, { page ->
            presenter.getPopular(page)
        }, hasMore = true)
        binding.recyclerView.addOnScrollListener(scrollListener)
    }

    private fun openDetailsPage(popularArticle: PopularArticle) {
        val fragment = PopularDetailsFragment.create(popularArticle)
        replaceFragment(fragment)
    }

    override fun showPopular(popularArticle: List<PopularArticle>) {
        popularAdapter.updateList(popularArticle)
    }
}