package com.vietsol.sekond.presentation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.dakuinternational.common.DataContent
import com.dakuinternational.common.base.BaseFragment
import com.dakuinternational.common.binding.viewBinding
import com.dakuinternational.common.delegates.AdapterOnItemClickListener
import com.vietsol.sekond.R
import com.vietsol.sekond.databinding.FragmentVariationBinding
import com.vietsol.sekond.presentation.NavigationDelegate
import com.vietsol.sekond.presentation.adapter.VariationAdapter

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