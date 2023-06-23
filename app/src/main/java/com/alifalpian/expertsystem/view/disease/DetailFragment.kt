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
import com.bumptech.glide.Glide

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

        // Mengambil data dari argumen atau Intent jika digunakan sebagai Fragment dalam Activity
        val penyakit = arguments?.getString("penyakit")
        val penjelasanPenyakit = arguments?.getString("penyakit")
        val penjelasanPencegahan = arguments?.getString("Pencegahan")
        val penjelasanDiagnosis = arguments?.getString("diagnosis")
        val penjelasanPerawatan = arguments?.getString("perawatan")
        val foto = arguments?.getString("foto")


        binding.txtPenyakit.text = penyakit
        binding.txtPenjelasanPenyakit.text = penjelasanPenyakit
        binding.txtPenjelasanPencegahan.text = penjelasanPencegahan
        binding.txtPenjelasanDiagnosis.text = penjelasanDiagnosis
        binding.txtPenjelasanPerawatan.text = penjelasanPerawatan
        Glide.with(requireContext()).load(foto).into(binding.image)

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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireActivity().onBackPressedDispatcher.addCallback(this) {
            findNavController().navigateUp()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
