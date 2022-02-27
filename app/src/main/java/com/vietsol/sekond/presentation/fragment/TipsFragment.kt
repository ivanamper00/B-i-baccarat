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
import com.vietsol.sekond.databinding.FragmentTipsBinding
import com.vietsol.sekond.presentation.adapter.TipsAdapter

class TipsFragment : BaseFragment(R.layout.fragment_tips) {

    val binding by viewBinding(FragmentTipsBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tipsRecycler.adapter = TipsAdapter()
        binding.tipsRecycler.layoutManager = LinearLayoutManager(requireContext())
    }

}