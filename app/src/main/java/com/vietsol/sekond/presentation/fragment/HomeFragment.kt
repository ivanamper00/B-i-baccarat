package com.vietsol.sekond.presentation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.dakuinternational.common.DataContent
import com.dakuinternational.common.base.BaseFragment
import com.dakuinternational.common.binding.viewBinding
import com.vietsol.sekond.R
import com.vietsol.sekond.databinding.FragmentHomeBinding
import com.vietsol.sekond.presentation.NavigationDelegate
import com.vietsol.sekond.presentation.adapter.HomeAdapter

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