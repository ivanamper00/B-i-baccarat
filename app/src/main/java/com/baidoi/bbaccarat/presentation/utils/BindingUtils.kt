package com.baidoi.bbaccarat.presentation.utils

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dakuinternational.common.delegates.AdapterOnItemClickListener
import com.baidoi.bbaccarat.presentation.adapter.NavigationAdapter

@BindingAdapter("android:navListOnClick", requireAll = true )
fun navigationList(recycler: RecyclerView, onClick: AdapterOnItemClickListener<Int>){
    recycler.adapter = NavigationAdapter(onClick)
    recycler.layoutManager = LinearLayoutManager(recycler.context)
}