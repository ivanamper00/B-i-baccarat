package com.baidoi.bbaccarat.presentation.fragment

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.dakuinternational.common.DataContent
import com.dakuinternational.common.base.BaseFragment
import com.dakuinternational.common.binding.viewBinding
import com.dakuinternational.common.delegates.AdapterOnItemClickListener
import com.baidoi.bbaccarat.R
import com.baidoi.bbaccarat.databinding.FragmentVariationBinding
import com.baidoi.bbaccarat.presentation.NavigationDelegate
import com.baidoi.bbaccarat.presentation.adapter.VariationAdapter

class VariationFragment : BaseFragment(R.layout.fragment_variation), AdapterOnItemClickListener<DataContent> {

    val binding by viewBinding(FragmentVariationBinding::bind)
    val delegate by lazy {
        requireActivity() as NavigationDelegate
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.variationsRecycler.adapter = VariationAdapter(this)
        binding.variationsRecycler.layoutManager = LinearLayoutManager(requireContext())
    }

    override fun onItemClick(data: DataContent) {
        delegate.onVariationClick(data)
    }
}