package com.example.nytimesclean.detailsMostPopular

import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.text.util.Linkify
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.nytimesclean.R
import com.example.nytimesclean.common.mvp.BaseFragment
import com.example.nytimesclean.databinding.FragmentMostPopularDetailsBinding
import com.example.nytimesclean.mostPopular.model.PopularArticle
import com.example.nytimesclean.utils.Constants

class MostPopularDetailsFragment : BaseFragment(R.layout.fragment_most_popular_details),
    MostPopularDetailsContract.PopularView {

    private lateinit var binding: FragmentMostPopularDetailsBinding
    private val popularArticle: PopularArticle? by lazy {
        arguments?.getParcelable(Constants.POPULAR_KEY)
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
        showPopular()
    }

    override fun showPopular() {
        with(binding) {
            textViewTitle.text = popularArticle?.title
            textViewByline.text = popularArticle?.byline
            textViewKeywords.text = popularArticle?.adxKeywords
            val source = popularArticle?.url ?: ""
            textViewLink.text = String.format("For more tap: %s", source)
            textViewLink.autoLinkMask = Linkify.WEB_URLS
            textViewLink.movementMethod = LinkMovementMethod.getInstance()
            textViewDate.text = popularArticle?.publishedDate
        }
    }
}