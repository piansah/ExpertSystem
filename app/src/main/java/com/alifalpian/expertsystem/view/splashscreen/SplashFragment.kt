package com.alifalpian.expertsystem.view.splashscreen

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.alifalpian.expertsystem.R
import com.alifalpian.expertsystem.databinding.FragmentSplashBinding

class SplashFragment : Fragment() {
    private lateinit var sharedPrefs: SharedPreferences
    private var _binding: FragmentSplashBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSplashBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedPrefs = requireContext().getSharedPreferences("DataUser", Context.MODE_PRIVATE)


        if (sharedPrefs.contains("user_id")) {
            Handler().postDelayed({
                findNavController().navigate(R.id.action_splashFragment_to_homeFragment)
            }, 1000)
        }else{
            Handler().postDelayed({
                findNavController().navigate(R.id.action_splashFragment_to_loginFragment)
            }, 1000)

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}