package com.example.nytimesclean.main_page.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.nytimesclean.common.ui.diffUtil.DiffUtilMain
import com.example.nytimesclean.databinding.ItemArticleBinding
import com.example.nytimesclean.main_page.model.Article

class ArticlesAdapter(
    private val onItemClick: (article: Article) -> Unit
) : RecyclerView.Adapter<ArticlesAdapter.ViewHolder>() {

    private var data = mutableListOf<Article>()
    fun updateList(article: List<Article>) {
        val diffCallback = DiffUtilMain(data, article)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        data = article as MutableList<Article>
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemArticleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding, onItemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class ViewHolder(
        private val binding: ItemArticleBinding,
        private val onItemClick: (article: Article) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(article: Article) {
            with(binding) {
                textViewTitle.text = article.snippet
                textViewDescription.text = article.source
                val imageUrl = article.getFormatedImageURL()
                imageView.isVisible = !imageUrl.isNullOrEmpty()
                imageView.load(article.getFormatedImageURL())
            }

            itemView.setOnClickListener {
                onItemClick.invoke(article)
            }
        }
    }
}