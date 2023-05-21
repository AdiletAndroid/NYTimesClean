package com.example.nytimesclean.main.ui.details

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
import com.example.nytimesclean.databinding.FragmentMainPageDetailsBinding
import com.example.nytimesclean.main.model.Article
import com.example.nytimesclean.utils.popBackStack

private const val ARG_ARTICLE = "ARTICLE_KEY"

class MainPageDetailsFragment : BaseFragment(R.layout.fragment_main_page_details) {

    companion object {
        fun create(article: Article): MainPageDetailsFragment {
            val bundle = Bundle()
            bundle.putParcelable(ARG_ARTICLE, article)
            val fragment = MainPageDetailsFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    private lateinit var binding: FragmentMainPageDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainPageDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val article = arguments?.getParcelable(ARG_ARTICLE) as Article?
        article?.let { showArticle(it) }
        binding.toolbar.setNavigationOnClickListener {
            popBackStack()
        }
    }

    private fun showArticle(article: Article) {
        with(binding) {
            textViewTitle.text = article.snippet
            val imageUrl = article.getFormatedImageURL()
            imageView.isVisible = !imageUrl.isNullOrEmpty()
            imageView.load(article.getFormatedImageURL())
            textViewContent.text = article.leadParagraph
            textViewType.text = article.typeOfMaterial
            val source = article.webUrl ?: ""
            textViewLink.text = String.format("For more tap: %s", source)
            textViewLink.autoLinkMask = Linkify.WEB_URLS
            textViewLink.movementMethod = LinkMovementMethod.getInstance()
            textViewDate.text = article.pubDate
        }
    }
}