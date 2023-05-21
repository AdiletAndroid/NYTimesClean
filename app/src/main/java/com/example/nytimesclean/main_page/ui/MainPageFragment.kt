package com.example.nytimesclean.main_page.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nytimesclean.R
import com.example.nytimesclean.common.mvp.BaseMvpFragment
import com.example.nytimesclean.common.ui.endlessScroll.EndlessScrollListener
import com.example.nytimesclean.databinding.FragmentMainPageBinding
import com.example.nytimesclean.main_page_details_fragment.MainPageDetailsFragment
import com.example.nytimesclean.main_page.model.Article
import com.example.nytimesclean.main_page.ui.adapter.ArticlesAdapter
import com.example.nytimesclean.utils.Constants.ARTICLE_KEY
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainPageFragment :
    BaseMvpFragment<MainPageContract.MainPageView, MainPageContract.MainPagePresenter>(R.layout.fragment_main_page),
    MainPageContract.MainPageView {

    override val presenter: MainPagePresenter by viewModel()
    private lateinit var binding: FragmentMainPageBinding
    private val adapter: ArticlesAdapter by lazy {
        ArticlesAdapter { article ->
            openDetailsPage(article)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainPageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.layoutManager = layoutManager

        binding.recyclerView.adapter = adapter

        val scrollListener = EndlessScrollListener(layoutManager, { page ->
            presenter.getArticles(page)
        }, hasMore = true)
        binding.recyclerView.addOnScrollListener(scrollListener)

        presenter.getArticles(1)
    }

    override fun showArticles(article: List<Article>) {
        adapter.updateList(article)
    }

    private fun openDetailsPage(article: Article) {
        val bundle = Bundle()
        bundle.putParcelable(ARTICLE_KEY, article)
        val fragment = MainPageDetailsFragment()
        fragment.arguments = bundle
        loadFragment(fragment)
    }

    private fun loadFragment(fragment: Fragment) {
        val transaction = requireActivity().supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}