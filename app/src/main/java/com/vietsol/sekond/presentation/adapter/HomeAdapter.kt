package com.vietsol.sekond.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dakuinternational.common.DataContent
import com.dakuinternational.common.utils.clipToBackground
import com.vietsol.sekond.data.BaccaratAssets
import com.vietsol.sekond.databinding.ItemHomeBinding

class HomeAdapter(var onClickListener: OnClickListener) : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    var list = BaccaratAssets.home
    class ViewHolder(var binding: ItemHomeBinding): RecyclerView.ViewHolder(binding.root) {
        fun setData(data: DataContent, onClickListener: OnClickListener){
            binding.home = data
            binding.constraintView.setOnClickListener { onClickListener.onItemClick(data) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemHomeBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(list[position], onClickListener)
    }

    override fun getItemCount(): Int = list.size

    interface OnClickListener{
        fun onItemClick(data: DataContent)
    }
}