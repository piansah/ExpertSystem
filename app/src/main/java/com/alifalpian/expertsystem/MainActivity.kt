package com.alifalpian.expertsystem

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.alifalpian.expertsystem.databinding.ActivityMainBinding

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Mendapatkan NavHostFragment dan NavController dari fragmentContainerView.
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController

        // Menambahkan listener untuk mengubah visibilitas bottom navigation berdasarkan destinasi.
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

        // Mengatur bottom navigation dengan navController.
        binding.bottomNavigation.setupWithNavController(navController)

        // Menambahkan listener untuk bottom navigation untuk melakukan navigasi ke destinasi tertentu.
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

    // Menampilkan bottom navigation.
    private fun showBottomNav() {
        binding.bottomNavigation.visibility = View.VISIBLE
    }

    // Menyembunyikan bottom navigation.
    private fun hideBottomNav() {
        binding.bottomNavigation.visibility = View.GONE
    }

    // Fungsi untuk logout (menghapus data pengguna dari Shared Preferences dan mengarahkan ke halaman LoginFragment).
    private fun signOut() {
        val sharedPrefs = getSharedPreferences("DataUser", MODE_PRIVATE)
        val editor = sharedPrefs.edit()
        editor.clear()
        editor.apply()
        Toast.makeText(this, "Anda telah Logout", Toast.LENGTH_SHORT).show()
        findNavController(R.id.fragmentContainerView).navigate(R.id.loginFragment)
    }

    // Menangani tombol kembali.
    // Jika berada di halaman HomeFragment, ProfileFragment, atau AboutFragment,
    // maka tombol kembali tidak akan melakukan apa-apa.
    // Jika berada di halaman lain, maka akan melakukan aksi kembali seperti biasa.
    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        val navController = findNavController(R.id.fragmentContainerView)
        val currentFragment = navController.currentDestination?.id

        if (currentFragment == R.id.homeFragment ||
            currentFragment == R.id.profileFragment ||
            currentFragment == R.id.aboutFragment
        ) {
            // Tidak melakukan apa-apa jika berada di halaman HomeFragment, ProfileFragment, atau AboutFragment.
        } else {
            // Melakukan aksi kembali seperti biasa untuk halaman lain.
            super.onBackPressed()
        }
    }
}
