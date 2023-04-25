package com.example.nytimesclean.detailsPage.ui

import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.text.util.Linkify
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import coil.load
import com.example.nytimesclean.R
import com.example.nytimesclean.common.mvp.BaseFragment
import com.example.nytimesclean.databinding.FragmentDetailsBinding
import com.example.nytimesclean.mainPage.model.Article
import com.example.nytimesclean.utils.Constants.KEY

class DetailsPageFragment : BaseFragment(R.layout.fragment_details), DetailsPageContract.View {

    private lateinit var binding: FragmentDetailsBinding
    private val article: Article? by lazy {
        arguments?.getParcelable(KEY)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showArticle()
    }

    override fun showArticle() {
        with(binding) {
            textViewTitle.text = article?.snippet
            val imageUrl = article?.getFormatedImageURL()
            imageView.isVisible = !imageUrl.isNullOrEmpty()
            imageView.load(article?.getFormatedImageURL())
            textViewContent.text = article?.leadParagraph
            textViewType.text = article?.typeOfMaterial
            val source = article?.webUrl ?: ""
            textViewLink.text = String.format("For more tap: %s", source)
            textViewLink.autoLinkMask = Linkify.WEB_URLS
            textViewLink.movementMethod = LinkMovementMethod.getInstance()
            textViewDate.text = article?.pubDate
        }
    }
}