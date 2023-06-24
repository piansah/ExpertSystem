package com.alifalpian.expertsystem.view.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.alifalpian.expertsystem.R
import com.alifalpian.expertsystem.databinding.FragmentAboutBinding

class AboutFragment : Fragment() {
    private var _binding: FragmentAboutBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAboutBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.bottomNavigation.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_home -> {
                    findNavController().navigate(R.id.action_aboutFragment_to_homeFragment)
                    true
                }
                R.id.nav_account -> {
                    findNavController().navigate(R.id.action_aboutFragment_to_profileFragment)
                    true
                }
                R.id.nav_about -> {
                    findNavController().navigate(R.id.action_aboutFragment_self)
                    true
                }
                R.id.nav_logout -> {
                    // Tindakan yang dilakukan saat item "Logout" dipilih
                    true
                }
                else -> false
            }
        }

        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireActivity().onBackPressedDispatcher.addCallback(this) {
            findNavController().navigateUp()

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}


