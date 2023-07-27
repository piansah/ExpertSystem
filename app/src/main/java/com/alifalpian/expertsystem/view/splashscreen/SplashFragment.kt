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

    // Membuat tampilan fragment dengan meng-inflate layout FragmentSplashBinding.
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSplashBinding.inflate(inflater, container, false)
        return binding.root
    }

    // Mengatur tindakan yang dilakukan setelah tampilan fragment dibuat.
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Mendapatkan Shared Preferences dengan nama "DataUser" dan mode private.
        sharedPrefs = requireContext().getSharedPreferences("DataUser", Context.MODE_PRIVATE)

        // Cek apakah terdapat "user_id" di dalam Shared Preferences.
        // Jika ada, maka akan diarahkan ke halaman HomeFragment.
        // Jika tidak ada, maka akan diarahkan ke halaman LoginFragment.
        Handler().postDelayed({
            if (sharedPrefs.contains("user_id")) {
                findNavController().navigate(R.id.action_splashFragment_to_homeFragment)
            } else {
                findNavController().navigate(R.id.action_splashFragment_to_loginFragment)
            }
        }, 1000)
    }

    // Membersihkan binding saat view fragment dihancurkan.
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
