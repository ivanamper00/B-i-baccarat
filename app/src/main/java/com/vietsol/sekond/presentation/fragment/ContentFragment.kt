package com.vietsol.sekond.presentation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.navigation.fragment.navArgs
import com.dakuinternational.common.DataContent
import com.dakuinternational.common.base.BaseFragment
import com.dakuinternational.common.binding.viewBinding
import com.dakuinternational.common.delegates.OnImageLoaded
import com.github.ybq.android.spinkit.sprite.Sprite
import com.github.ybq.android.spinkit.style.CubeGrid
import com.google.gson.Gson
import com.vietsol.sekond.R
import com.vietsol.sekond.databinding.FragmentContentBinding


class ContentFragment : BaseFragment(R.layout.fragment_content), OnImageLoaded {

    val binding by viewBinding(FragmentContentBinding::bind)
    val args: ContentFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val item = Gson().fromJson(args.content, DataContent::class.java)
        binding.item = item
        binding.imageLoaded = this
        val doubleBounce: Sprite = CubeGrid()
        (binding.spinKit as ProgressBar).indeterminateDrawable = doubleBounce

        if(item.asset.isNullOrEmpty()){
            binding.constraintLayout.visibility = View.GONE
        }
    }

    override fun onLoad() {
       binding.spinKit.visibility = View.GONE
    }

}