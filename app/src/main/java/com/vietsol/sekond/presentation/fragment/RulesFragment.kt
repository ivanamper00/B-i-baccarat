package com.vietsol.sekond.presentation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.dakuinternational.common.base.BaseFragment
import com.dakuinternational.common.binding.viewBinding
import com.vietsol.sekond.R
import com.vietsol.sekond.databinding.FragmentRulesBinding
import com.vietsol.sekond.presentation.adapter.RulesAdapter

class RulesFragment : BaseFragment(R.layout.fragment_rules) {

    val binding by viewBinding(FragmentRulesBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rulesRecycler.adapter = RulesAdapter()
        binding.rulesRecycler.layoutManager = LinearLayoutManager(requireContext())
    }
}