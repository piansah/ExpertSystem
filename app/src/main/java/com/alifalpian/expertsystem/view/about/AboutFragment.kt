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
        // Inflate layout untuk tampilan AboutFragment
        _binding = FragmentAboutBinding.inflate(inflater, container, false)
        val view = binding.root

        return view
    }

    // Function yang dipanggil saat fragment dibuat, digunakan untuk menangani tombol kembali
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Mengatur aksi tombol kembali untuk kembali ke fragment sebelumnya
        requireActivity().onBackPressedDispatcher.addCallback(this) {
            findNavController().navigateUp()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Membersihkan binding saat view fragment dihancurkan
        _binding = null
    }
}


