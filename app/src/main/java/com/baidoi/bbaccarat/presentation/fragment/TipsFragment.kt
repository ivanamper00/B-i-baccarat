package com.baidoi.bbaccarat.presentation.fragment

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.dakuinternational.common.base.BaseFragment
import com.dakuinternational.common.binding.viewBinding
import com.baidoi.bbaccarat.R
import com.baidoi.bbaccarat.databinding.FragmentTipsBinding
import com.baidoi.bbaccarat.presentation.adapter.TipsAdapter

class TipsFragment : BaseFragment(R.layout.fragment_tips) {

    val binding by viewBinding(FragmentTipsBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tipsRecycler.adapter = TipsAdapter()
        binding.tipsRecycler.layoutManager = LinearLayoutManager(requireContext())
    }

}