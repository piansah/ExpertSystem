package com.alifalpian.expertsystem

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.alifalpian.expertsystem.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.homeFragment, R.id.profileFragment ,R.id.aboutFragment -> {
                    showBottomNav()
                }

                else -> {
                    hideBottomNav()
                }
            }
        }

        binding.bottomNavigation.setupWithNavController(navController)

        binding.bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.homeFragment, R.id.profileFragment,R.id.aboutFragment -> {
                    findNavController(R.id.fragmentContainerView).navigate(item.itemId)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.loginFragment -> {
                    signOut()
                    return@setOnNavigationItemSelectedListener true
                }
                else -> return@setOnNavigationItemSelectedListener false
            }
        }
    }

    private fun showBottomNav() {
        binding.bottomNavigation.visibility = View.VISIBLE
    }

    private fun hideBottomNav() {
        binding.bottomNavigation.visibility = View.GONE
    }

    private fun signOut() {
        val sharedPrefs = getSharedPreferences("DataUser", MODE_PRIVATE)
        val editor = sharedPrefs.edit()
        editor.clear()
        editor.apply()
        findNavController(R.id.fragmentContainerView).navigate(R.id.loginFragment)
    }

    override fun onBackPressed() {
        val navController = findNavController(R.id.fragmentContainerView)
        val currentFragment = navController.currentDestination?.id

        if (currentFragment == R.id.homeFragment ||
            currentFragment == R.id.profileFragment ||
            currentFragment == R.id.aboutFragment
        ) {
            // Do nothing
        } else {
            super.onBackPressed()
        }
    }
}
