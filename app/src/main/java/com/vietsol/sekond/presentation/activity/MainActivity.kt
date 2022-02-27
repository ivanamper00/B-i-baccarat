package com.vietsol.sekond.presentation.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.dakuinternational.common.DataContent
import com.dakuinternational.common.base.BaseActivity
import com.dakuinternational.common.delegates.AdapterOnItemClickListener
import com.dakuinternational.common.ui.ActivityViewModel
import com.google.gson.Gson
import com.vietsol.sekond.R
import com.vietsol.sekond.databinding.ActivityMainBinding
import com.vietsol.sekond.presentation.NavigationDelegate
import com.vietsol.sekond.presentation.fragment.HomeFragmentDirections
import com.vietsol.sekond.presentation.fragment.VariationFragmentDirections

class MainActivity : BaseActivity(), NavigationDelegate, AdapterOnItemClickListener<Int> {

    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<ActivityViewModel>()
    private val navHostFragment by lazy {
        supportFragmentManager.findFragmentById(R.id.navigation_host) as NavHostFragment
    }
    private val navController get() = navHostFragment.navController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val inflater = LayoutInflater.from(this)
        binding = ActivityMainBinding.inflate(inflater, null, false)
        setContentView(binding.root)
        binding.clickListener = this

        val actionBarDrawerToggle = ActionBarDrawerToggle(
            this, binding.mainDrawerLayout, binding.toolbar,
            R.string.menu_drawer_open, R.string.menu_drawer_close
        )
        binding.mainDrawerLayout.addDrawerListener(actionBarDrawerToggle)
        binding.viewDrawer.setOnClickListener {
            openDrawer(true)
        }

        navController.addOnDestinationChangedListener { _, destination, _ ->
            binding.appBarLayout.visibility = if(destination.id == R.id.contentFragment)  View.GONE else View.VISIBLE
        }

        binding.textViewExit.setOnClickListener {
            finish()
        }
    }

    private fun openDrawer(isOpen: Boolean) {
        if(isOpen) binding.mainDrawerLayout.openDrawer(GravityCompat.START)
        else binding.mainDrawerLayout.closeDrawer(GravityCompat.START)
    }


    companion object{
        fun createIntent(context: Context) = Intent(context, MainActivity::class.java)
    }

    override fun onItemClick(data: Int) {
        when(data){
            0 -> navController.navigate(R.id.homeFragment)
            1 -> navController.navigate(R.id.rulesFragment)
            2 -> navController.navigate(R.id.tipsFragment)
            3 -> navController.navigate(R.id.variationFragment)
        }
        openDrawer(false)
    }

    override fun toHomeDescription(data: DataContent) {
        val direction = HomeFragmentDirections.navigateToHomeContent(Gson().toJson(data))
        navController.navigate(direction)
    }

    override fun onVariationClick(data: DataContent) {
       val direction = VariationFragmentDirections.navigateToVariationContent(Gson().toJson(data))
        navController.navigate(direction)
    }
}