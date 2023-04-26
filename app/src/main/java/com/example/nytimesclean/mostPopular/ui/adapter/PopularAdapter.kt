package com.example.nytimesclean.mostPopular.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.nytimesclean.common.ui.diffUtil.DiffUtilPopular
import com.example.nytimesclean.databinding.ItemArticleBinding
import com.example.nytimesclean.mostPopular.model.PopularArticle

class PopularAdapter(
    private val onItemClick: (popularArticle: PopularArticle) -> Unit
) : RecyclerView.Adapter<PopularAdapter.ViewHolder>() {

    private var popularData = mutableListOf<PopularArticle>()

    fun updateList(popularArticle: List<PopularArticle>) {
        val diffCallback = DiffUtilPopular(popularData, popularArticle)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        popularData = popularArticle as MutableList<PopularArticle>
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemArticleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding, onItemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(popularData[position])
    }

    override fun getItemCount(): Int {
        return popularData.size
    }

    inner class ViewHolder(
        private val binding: ItemArticleBinding,
        private val onItemClick: (article: PopularArticle) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(article: PopularArticle) {
            with(binding) {
                textViewTitle.text = article.title
                textViewDescription.text = article.source
                imageView.isVisible = imageView.isGone
            }

            itemView.setOnClickListener {
                onItemClick.invoke(article)
            }
        }
    }
}