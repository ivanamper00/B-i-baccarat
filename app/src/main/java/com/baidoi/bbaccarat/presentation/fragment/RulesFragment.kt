package com.baidoi.bbaccarat.presentation.fragment

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.dakuinternational.common.base.BaseFragment
import com.dakuinternational.common.binding.viewBinding
import com.baidoi.bbaccarat.R
import com.baidoi.bbaccarat.databinding.FragmentRulesBinding
import com.baidoi.bbaccarat.presentation.adapter.RulesAdapter

class RulesFragment : BaseFragment(R.layout.fragment_rules) {

    val binding by viewBinding(FragmentRulesBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rulesRecycler.adapter = RulesAdapter()
        binding.rulesRecycler.layoutManager = LinearLayoutManager(requireContext())
    }
}