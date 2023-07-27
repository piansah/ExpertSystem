package com.alifalpian.expertsystem.view.disease

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.alifalpian.expertsystem.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    // Membuat tampilan fragment dengan meng-inflate layout FragmentDetailBinding.
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    // Mengisi tampilan dengan data dari argument Bundle dan menampilkan tombol back pada ActionBar.
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Ambil Data by Bundle dari fragment sebelumnya.
        val penyakit = arguments?.getString("namaPenyakit")
        val penjelasanPenyakit = arguments?.getString("penjelasanPenyakit")
        val penjelasanPencegahan = arguments?.getString("penjelasanPencegahan")
        val penjelasanDiagnosa = arguments?.getString("penjelasanDiagnosa")
        val penjelasanPerawatan = arguments?.getString("penjelasanPerawatan")

        // Mengisi data ke tampilan.
        binding.txtPenyakit.text = penyakit
        binding.txtPenjelasanPenyakit.text = penjelasanPenyakit
        binding.txtPenjelasanPencegahan.text = penjelasanPencegahan
        binding.txtPenjelasanDiagnosa.text = penjelasanDiagnosa
        binding.txtPenjelasanPerawatan.text = penjelasanPerawatan

        // Menampilkan tombol back pada ActionBar.
        setHasOptionsMenu(true)
    }

    // Mengatur aksi tombol back pada ActionBar untuk kembali ke fragment sebelumnya.
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                // Kembali ke Fragment sebelumnya.
                findNavController().popBackStack()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    // Function yang dipanggil saat fragment dibuat, digunakan untuk menangani tombol kembali.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Mengatur aksi tombol kembali untuk kembali ke fragment sebelumnya.
        requireActivity().onBackPressedDispatcher.addCallback(this) {
            findNavController().navigateUp()
        }
    }

    // Membersihkan referensi view binding (_binding) ketika fragment dihancurkan.
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
