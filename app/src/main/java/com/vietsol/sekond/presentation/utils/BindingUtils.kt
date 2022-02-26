package com.vietsol.sekond.presentation.utils

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dakuinternational.common.delegates.AdapterOnItemClickListener
import com.vietsol.sekond.presentation.adapter.NavigationAdapter

@BindingAdapter("android:navListOnClick", requireAll = true )
fun navigationList(recycler: RecyclerView, onClick: AdapterOnItemClickListener<Int>){
    recycler.adapter = NavigationAdapter(onClick)
    recycler.layoutManager = LinearLayoutManager(recycler.context)
}