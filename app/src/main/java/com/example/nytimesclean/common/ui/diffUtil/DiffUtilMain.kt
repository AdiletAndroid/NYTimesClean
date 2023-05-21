package com.example.nytimesclean.common.ui.diffUtil

import androidx.recyclerview.widget.DiffUtil
import com.example.nytimesclean.main_page.model.Article

class DiffUtilMain(
    private val oldList: MutableList<Article>,
    private val newList: List<Article>
) : DiffUtil.Callback() {

    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition].id == newList[newItemPosition].id

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition] == newList[newItemPosition]
}
