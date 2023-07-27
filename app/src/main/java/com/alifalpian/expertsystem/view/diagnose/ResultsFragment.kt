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

    // Membuat tampilan fragment dengan meng-inflate layout FragmentResultBinding.
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentResultBinding.inflate(inflater, container, false)
        val view = binding.root

        // Mendapatkan data diagnosa dari arguments yang dikirimkan dari fragment sebelumnya.
        val diagnosa = arguments?.getString("diagnosa")

        // Menampilkan hasil diagnosa pada tampilan dengan menggunakan format teks HTML.
        val hasilDiagnosa = "Berdasarkan gejala yang dipilih, mata anda mengalami <b>$diagnosa</b>"
        binding.HasilDiagnosa.text = HtmlCompat.fromHtml(hasilDiagnosa, HtmlCompat.FROM_HTML_MODE_LEGACY)

        // Menambahkan aksi ketika tombol "Kembali Diagnosa" ditekan.
        // Ketika tombol ditekan, fragment akan melakukan navigasi kembali ke halaman DiagnoseFragment.
        binding.btnKembaliDiagnosa.setOnClickListener{
            findNavController().navigate(R.id.action_resultFragment_to_diagnoseFragment)
        }

        // Menambahkan aksi ketika tombol "Menu Utama" ditekan.
        // Ketika tombol ditekan, fragment akan melakukan navigasi ke halaman HomeFragment.
        binding.btnMenuUtama.setOnClickListener{
            findNavController().navigate(R.id.action_resultFragment_to_homeFragment)
        }

        return view
    }

    // Membersihkan referensi view binding (_binding) ketika fragment dihancurkan.
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    // Menambahkan aksi ketika tombol back ditekan.
    // Ketika tombol back ditekan, fragment akan melakukan navigasi ke atas (navigateUp) menggunakan NavController.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireActivity().onBackPressedDispatcher.addCallback(this) {
            findNavController().navigateUp()
        }
    }
}
