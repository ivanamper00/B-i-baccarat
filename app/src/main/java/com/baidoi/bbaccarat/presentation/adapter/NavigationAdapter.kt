package com.baidoi.bbaccarat.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dakuinternational.common.delegates.AdapterOnItemClickListener
import com.baidoi.bbaccarat.data.BaccaratAssets
import com.baidoi.bbaccarat.databinding.ItemNavigationBinding

class NavigationAdapter(var onClick: AdapterOnItemClickListener<Int>) : RecyclerView.Adapter<NavigationAdapter.ViewHolder>() {

    var list = BaccaratAssets.navigation
    class ViewHolder(var binding: ItemNavigationBinding): RecyclerView.ViewHolder(binding.root) {
        fun setItem(item: String, onClick: AdapterOnItemClickListener<Int>) {
            binding.item = item
            binding.root.setOnClickListener{
                onClick.onItemClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemNavigationBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setItem(list[position], onClick)
    }

    override fun getItemCount(): Int = list.size
}