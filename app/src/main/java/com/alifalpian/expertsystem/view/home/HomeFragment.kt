package com.alifalpian.expertsystem.view.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.alifalpian.expertsystem.R
import com.alifalpian.expertsystem.databinding.FragmentHomeBinding
import com.google.firebase.auth.FirebaseAuth

class HomeFragment : Fragment() {
    private var _binding : FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        auth = FirebaseAuth.getInstance()

        val currentUser = auth.currentUser
        if (currentUser == null) {
            findNavController().navigate(R.id.action_homeFragment_to_loginFragment)
        }

        binding.LayoutDiagnosa.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_pradiagnoseFragment)
        }
        binding.LayoutRiwayat.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_historyFragment)
        }
        binding.LayoutInformasi.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_diseaseFragment)
        }
        binding.LayoutPetunjukPengguna.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_guideFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
