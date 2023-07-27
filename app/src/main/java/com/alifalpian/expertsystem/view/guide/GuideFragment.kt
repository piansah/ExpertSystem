package com.alifalpian.expertsystem.view.guide

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

import com.alifalpian.expertsystem.databinding.FragmentGuideBinding

class GuideFragment : Fragment() {
    private var _binding: FragmentGuideBinding? = null
    private val binding get() = _binding!!

    // Membuat tampilan fragment dengan meng-inflate layout FragmentGuideBinding.
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGuideBinding.inflate(inflater, container, false)
        return binding.root
    }

    // Membuat aksi tombol kembali agar kembali ke Fragment sebelumnya atau menutup aplikasi jika tidak ada Fragment sebelumnya.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireActivity().onBackPressedDispatcher.addCallback(this) {
            findNavController().navigateUp()
        }
    }

    // Membersihkan binding saat view fragment dihancurkan untuk mencegah memory leak.
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
