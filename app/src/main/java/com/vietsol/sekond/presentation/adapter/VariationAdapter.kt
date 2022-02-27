package com.vietsol.sekond.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.recyclerview.widget.RecyclerView
import com.dakuinternational.common.DataContent
import com.dakuinternational.common.delegates.AdapterOnItemClickListener
import com.dakuinternational.common.delegates.OnImageLoaded
import com.github.ybq.android.spinkit.sprite.Sprite
import com.github.ybq.android.spinkit.style.CubeGrid
import com.github.ybq.android.spinkit.style.DoubleBounce
import com.vietsol.sekond.data.BaccaratAssets
import com.vietsol.sekond.databinding.ItemVariationBinding


class VariationAdapter(var adapterOnClick: AdapterOnItemClickListener<DataContent>): RecyclerView.Adapter<VariationAdapter.ViewHolder>() {

    val list = BaccaratAssets.variation

    class ViewHolder(var binding: ItemVariationBinding): RecyclerView.ViewHolder(binding.root), OnImageLoaded {
        fun setItem(dataContent: DataContent, adapterOnClick: AdapterOnItemClickListener<DataContent>) {
            binding.item = dataContent
            binding.imageLoaded = this

            val doubleBounce: Sprite = CubeGrid()
            (binding.spinKit as ProgressBar).indeterminateDrawable = doubleBounce

            binding.root.setOnClickListener {
                adapterOnClick.onItemClick(dataContent)
            }
        }

        override fun onLoad() {
            binding.spinKit.visibility = View.GONE
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemVariationBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.setItem(list[position],adapterOnClick)
    }

    override fun getItemCount(): Int = list.size
}