package com.example.nytimesclean.popular.ui.details

import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.text.util.Linkify
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.nytimesclean.R
import com.example.nytimesclean.common.mvp.BaseFragment
import com.example.nytimesclean.databinding.FragmentMostPopularDetailsBinding
import com.example.nytimesclean.popular.model.PopularArticle
import com.example.nytimesclean.utils.popBackStack

const val ARG_POPULAR = "POPULAR_KEY"

class PopularDetailsFragment : BaseFragment(R.layout.fragment_most_popular_details) {

    private lateinit var binding: FragmentMostPopularDetailsBinding

    companion object {
        fun create(popularArticle: PopularArticle): PopularDetailsFragment {
            val bundle = Bundle()
            bundle.putParcelable(ARG_POPULAR, popularArticle)
            val fragment = PopularDetailsFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMostPopularDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val popularArticle = arguments?.getParcelable(ARG_POPULAR) as PopularArticle?
        popularArticle?.let { showPopular(it) }
        binding.toolbar.setNavigationOnClickListener {
            popBackStack()
        }
    }

    private fun showPopular(popularArticle: PopularArticle) {
        with(binding) {
            textViewTitle.text = popularArticle.title
            textViewByline.text = popularArticle.byline
            textViewKeywords.text = popularArticle.adxKeywords
            val source = popularArticle.url ?: ""
            textViewLink.text = String.format("For more tap: %s", source)
            textViewLink.autoLinkMask = Linkify.WEB_URLS
            textViewLink.movementMethod = LinkMovementMethod.getInstance()
            textViewDate.text = popularArticle.publishedDate
        }
    }
}