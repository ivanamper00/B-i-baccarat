package com.baidoi.bbaccarat.presentation.fragment

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.dakuinternational.common.DataContent
import com.dakuinternational.common.base.BaseFragment
import com.dakuinternational.common.binding.viewBinding
import com.baidoi.bbaccarat.R
import com.baidoi.bbaccarat.databinding.FragmentHomeBinding
import com.baidoi.bbaccarat.presentation.NavigationDelegate
import com.baidoi.bbaccarat.presentation.adapter.HomeAdapter

class HomeFragment : BaseFragment(R.layout.fragment_home), HomeAdapter.OnClickListener {

    val binding by viewBinding(FragmentHomeBinding::bind)
    val delegate by lazy {
        requireActivity() as NavigationDelegate
    }
    lateinit var adapter:HomeAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        adapter = HomeAdapter(this)
        val layoutManager = GridLayoutManager(requireContext(),2, GridLayoutManager.VERTICAL, false)
        binding.homeRecyclerView.adapter = adapter
        binding.homeRecyclerView.layoutManager = layoutManager
    }

    override fun onItemClick(data: DataContent) {
        delegate.toHomeDescription(data)
    }

}