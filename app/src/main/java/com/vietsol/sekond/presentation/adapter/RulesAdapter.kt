package com.vietsol.sekond.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dakuinternational.common.DataContent
import com.vietsol.sekond.data.BaccaratAssets
import com.vietsol.sekond.databinding.ItemRulesBinding

class RulesAdapter: RecyclerView.Adapter<RulesAdapter.ViewHolder>() {

    var list = BaccaratAssets.rules

    class ViewHolder(var binding: ItemRulesBinding): RecyclerView.ViewHolder(binding.root) {
        fun setItem(dataContent: DataContent) {
            binding.item = dataContent
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemRulesBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setItem(list[position])
    }

    override fun getItemCount(): Int = list.size
}