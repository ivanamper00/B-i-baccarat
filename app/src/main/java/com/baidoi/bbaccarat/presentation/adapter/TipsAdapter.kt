package com.baidoi.bbaccarat.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dakuinternational.common.DataContent
import com.baidoi.bbaccarat.data.BaccaratAssets
import com.baidoi.bbaccarat.databinding.ItemTipsBinding

class TipsAdapter: RecyclerView.Adapter<TipsAdapter.ViewHolder>() {

    val list = BaccaratAssets.tipsAndTricks

    class ViewHolder(var binding: ItemTipsBinding): RecyclerView.ViewHolder(binding.root) {
        fun setItem(dataContent: DataContent) {
            binding.item = dataContent
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemTipsBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.setItem(list[position])
    }

    override fun getItemCount(): Int = list.size
}