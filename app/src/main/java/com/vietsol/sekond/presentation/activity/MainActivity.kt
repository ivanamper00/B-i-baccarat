package com.vietsol.sekond.presentation.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.dakuinternational.common.DataContent
import com.dakuinternational.common.base.BaseActivity
import com.dakuinternational.common.delegates.AdapterOnItemClickListener
import com.dakuinternational.common.ui.ActivityViewModel
import com.vietsol.sekond.R
import com.vietsol.sekond.databinding.ActivityMainBinding
import com.vietsol.sekond.presentation.NavigationDelegate

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

        viewModel.activityEvent.observe(this){
            when(it){

            }
        }

        var actionBarDrawerToggle = ActionBarDrawerToggle(
            this, binding.mainDrawerLayout, binding.toolbar,
            R.string.menu_drawer_open, R.string.menu_drawer_close
        )
        binding.mainDrawerLayout.addDrawerListener(actionBarDrawerToggle)

        binding.viewDrawer.setOnClickListener {
            binding.mainDrawerLayout.openDrawer(GravityCompat.START)
        }
    }

    override fun toHomeDescription(data: DataContent) {

    }

    companion object{
        fun createIntent(context: Context) = Intent(context, MainActivity::class.java)
    }

    override fun onItemClick(data: Int) {
        Toast.makeText(this, "$data", Toast.LENGTH_SHORT).show()
    }
}