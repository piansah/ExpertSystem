package com.alifalpian.expertsystem.view.diagnose

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.alifalpian.expertsystem.R

import com.alifalpian.expertsystem.databinding.FragmentPradiagnoseBinding

class PradiagnoseFragment : Fragment() {
    private var _binding: FragmentPradiagnoseBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPradiagnoseBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.btnMulaiDiagnosa.setOnClickListener{
            findNavController().navigate(R.id.action_pradiagnoseFragment_to_diagnoseFragment)
        }

        return view
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


