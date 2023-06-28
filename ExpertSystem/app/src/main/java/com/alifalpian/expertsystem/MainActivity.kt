package com.alifalpian.expertsystem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.alifalpian.expertsystem.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController

        navController.addOnDestinationChangedListener{ _, destination, _ ->
            when(destination.id){
                R.id.homeFragment, R.id.profileFragment, R.id.aboutFragment -> {
                    showBottomNav()
                }
                else -> hideBottomNav()
            }
        }

        binding.bottomNavigation.setOnItemSelectedListener {
            when(it.itemId){
                R.id.loginFragment ->{
                    logout()
                    Log.d("MainActivity", "Logout")
                    true

                }
                else ->{
                    Log.d("MainActivity", "Else")
                    false

                }
            }
        }
        binding.bottomNavigation.setupWithNavController(navController)
    }

    private fun showBottomNav() {
        binding.bottomNavigation.visibility = View.VISIBLE
    }

    private fun hideBottomNav() {
        binding.bottomNavigation.visibility = View.GONE
    }

    override fun onBackPressed() {
        val navController = findNavController(R.id.fragmentContainerView)
        val currentFragment = navController.currentDestination?.id

        if (currentFragment == R.id.homeFragment ||
            currentFragment == R.id.profileFragment ||
            currentFragment == R.id.aboutFragment)
        {
            // Do nothing
        } else {
            super.onBackPressed()
        }
    }

    fun logout(){
        val sharedPrefs = getSharedPreferences("DataUser", MODE_PRIVATE)
        val editor = sharedPrefs.edit()
        editor.clear()
        editor.apply()
        findNavController(R.id.fragmentContainerView).navigate(R.id.loginFragment)
    }
}

