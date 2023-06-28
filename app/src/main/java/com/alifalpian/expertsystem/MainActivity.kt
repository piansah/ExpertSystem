package com.alifalpian.expertsystem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.alifalpian.expertsystem.databinding.ActivityMainBinding
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.firebase.auth.FirebaseAuth
import android.content.Intent
import com.alifalpian.expertsystem.view.authentication.LoginFragment



class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var googleSignInClient: GoogleSignInClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.homeFragment, R.id.profileFragment, R.id.aboutFragment -> {
                    showBottomNav()
                }
                R.id.signOut -> {
                    signOut()
                    true
                }

                else -> hideBottomNav()
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
            currentFragment == R.id.aboutFragment
        ) {
            // Do nothing
        } else {
            super.onBackPressed()
        }
    }

    private fun signOut() {
        auth.signOut()
        val currentUser = auth.currentUser
        if (currentUser == null) {
            startActivity(Intent(this, LoginFragment::class.java))
            finish()
        }
        googleSignInClient.signOut().addOnCompleteListener(this) {
        }
    }


}
