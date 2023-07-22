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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Ambil Data by Bundle
        val penyakit = arguments?.getString("namaPenyakit")
        val penjelasanPenyakit = arguments?.getString("penjelasanPenyakit")
        val penjelasanPencegahan = arguments?.getString("penjelasanPencegahan")
        val penjelasanDiagnosa = arguments?.getString("penjelasanDiagnosa")
        val penjelasanPerawatan = arguments?.getString("penjelasanPerawatan")

        // Mengisi data ke tampilan
        binding.txtPenyakit.text = penyakit
        binding.txtPenjelasanPenyakit.text = penjelasanPenyakit
        binding.txtPenjelasanPencegahan.text = penjelasanPencegahan
        binding.txtPenjelasanDiagnosa.text = penjelasanDiagnosa
        binding.txtPenjelasanPerawatan.text = penjelasanPerawatan

        // Menampilkan tombol back
        setHasOptionsMenu(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                // Kembali ke Fragment sebelumnya
                findNavController().popBackStack()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
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
