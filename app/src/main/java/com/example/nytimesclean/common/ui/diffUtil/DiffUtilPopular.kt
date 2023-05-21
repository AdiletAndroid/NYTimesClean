package com.example.nytimesclean.common.ui.diffUtil

import androidx.recyclerview.widget.DiffUtil
import com.example.nytimesclean.popular.model.PopularArticle

class DiffUtilPopular (
    private val oldList: MutableList<PopularArticle>,
    private val newList: List<PopularArticle>
) : DiffUtil.Callback() {

    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition].id == newList[newItemPosition].id

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition] == newList[newItemPosition]
}