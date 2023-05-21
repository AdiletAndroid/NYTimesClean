package com.example.nytimesclean.most_popular.ui.adapter

import android.text.method.LinkMovementMethod
import android.text.util.Linkify
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.nytimesclean.common.ui.diffUtil.DiffUtilPopular
import com.example.nytimesclean.databinding.ItemPopularBinding
import com.example.nytimesclean.most_popular.model.PopularArticle

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
        val binding = ItemPopularBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding, onItemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(popularData[position])
    }

    override fun getItemCount(): Int {
        return popularData.size
    }

    inner class ViewHolder(
        private val binding: ItemPopularBinding,
        private val onItemClick: (popularArticle: PopularArticle) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(popularArticle: PopularArticle) {
            with(binding) {
                textViewTitle.text = popularArticle.title
                textViewByline.text = popularArticle.byline
                textViewSource.text = popularArticle.source
                val source = popularArticle.url ?: ""
                textViewUrl.text = String.format("For more tap: %s", source)
                textViewUrl.autoLinkMask = Linkify.WEB_URLS
                textViewUrl.movementMethod = LinkMovementMethod.getInstance()
            }

            itemView.setOnClickListener {
                onItemClick.invoke(popularArticle)
            }
        }
    }
}