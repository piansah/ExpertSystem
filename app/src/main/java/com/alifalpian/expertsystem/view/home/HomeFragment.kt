package com.alifalpian.expertsystem.view.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.alifalpian.expertsystem.R
import com.alifalpian.expertsystem.databinding.FragmentHomeBinding
import com.alifalpian.expertsystem.view.authentication.LoginFragment
import com.google.firebase.auth.FirebaseAuth

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var auth: FirebaseAuth

    // Membuat tampilan fragment dengan meng-inflate layout FragmentHomeBinding.
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    // Menyiapkan tampilan fragment dan mengatur aksi ketika tombol di klik.
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        auth = FirebaseAuth.getInstance()

        // Memeriksa apakah pengguna sudah login. Jika belum, akan diarahkan ke halaman login.
        val currentUser = auth.currentUser
        if (currentUser == null) {
            findNavController().navigate(R.id.action_homeFragment_to_loginFragment)
        }

        // Mengatur aksi ketika layout diagnosa diklik untuk berpindah ke fragment PradiagnoseFragment.
        binding.LayoutDiagnosa.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_pradiagnoseFragment)
        }

        // Mengatur aksi ketika layout riwayat diklik untuk berpindah ke fragment HistoryFragment.
        binding.LayoutRiwayat.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_historyFragment)
        }

        // Mengatur aksi ketika layout informasi diklik untuk berpindah ke fragment DiseaseFragment.
        binding.LayoutInformasi.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_diseaseFragment)
        }

        // Mengatur aksi ketika layout petunjuk pengguna diklik untuk berpindah ke fragment GuideFragment.
        binding.LayoutPetunjukPengguna.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_guideFragment)
        }
    }

    // Membersihkan binding saat view fragment dihancurkan.
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
