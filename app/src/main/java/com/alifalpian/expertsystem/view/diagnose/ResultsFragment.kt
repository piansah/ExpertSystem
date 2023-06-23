package com.alifalpian.expertsystem.view.diagnose


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.core.text.HtmlCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.alifalpian.expertsystem.R
import com.alifalpian.expertsystem.databinding.FragmentResultBinding

class ResultsFragment : Fragment() {
    private var _binding: FragmentResultBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentResultBinding.inflate(inflater, container, false)
        val view = binding.root

        val diagnosa = arguments?.getString("diagnosa")

        // Menampilkan data diagnosa di TextView
        val hasilDiagnosa =
            "Berdasarkan gejala yang dipilih, Hamster Anda mengalami <b>$diagnosa</b>"
        binding.HasilDiagnosa.text =
            HtmlCompat.fromHtml(hasilDiagnosa, HtmlCompat.FROM_HTML_MODE_LEGACY)

        // Konfigurasi kembali ke diagnosa

        binding.btnKembaliDiagnosa.setOnClickListener{
            findNavController().navigate(R.id.action_resultFragment_to_diagnoseFragment)
        }

        // Konfigurasi kembali ke home

        binding.btnMenuUtama.setOnClickListener{
            findNavController().navigate(R.id.action_resultFragment_to_homeFragment)
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireActivity().onBackPressedDispatcher.addCallback(this) {
            findNavController().navigateUp()
        }
    }
}
