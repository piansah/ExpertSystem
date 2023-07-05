package com.alifalpian.expertsystem.view.diagnose

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.alifalpian.expertsystem.R
import com.alifalpian.expertsystem.databinding.FragmentDiagnoseBinding

class DiagnoseFragment : Fragment() {
    private var _binding: FragmentDiagnoseBinding? = null
    private val binding get() = _binding!!

    private lateinit var CairanHidung : CheckBox
    private lateinit var Bersin : CheckBox
    private lateinit var Lesu : CheckBox
    private lateinit var KotoranBerwarnaHijau : CheckBox
    private lateinit var KotoranEncer : CheckBox
    private lateinit var SulitBernafas : CheckBox
    private lateinit var GatalPadaKulit : CheckBox
    private lateinit var JumlahKotoranBanyak : CheckBox
    private lateinit var EkorBasah : CheckBox
    private lateinit var PenyumbatanUsus : CheckBox
    private lateinit var DudukMembungkuk : CheckBox
    private lateinit var TubuhTerasaDingin : CheckBox
    private lateinit var SakitPerut : CheckBox
    private lateinit var TidurDiSudutKandang : CheckBox
    private lateinit var BauMenyengat : CheckBox
    private lateinit var NafasTerengahEngah : CheckBox
    private lateinit var TidakNafsuMakan : CheckBox
    private lateinit var BAKBerdarah : CheckBox
    private lateinit var BergerakSangatLamban : CheckBox
    private lateinit var btnDiagnosa : Button

    //daftar penyakit
    val P1 = "Salesma"
    val P2 = "Diare"
    val P3 = "Diare (Jamur)"
    val P4 = "Diare (Bakteri)"
    val P5 = "Flu Hamster"
    val P6 = "Ekor Basah"
    val P7 = "Sembelit"
    val P8 = "Batu Ginjal"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDiagnoseBinding.inflate(inflater, container, false)
        val view = binding.root

        // Inisialisasi checkbox
        CairanHidung = binding.G1
        Bersin = binding.G2
        Lesu = binding.G3
        KotoranBerwarnaHijau = binding.G4
        KotoranEncer = binding.G5
        SulitBernafas = binding.G6
        GatalPadaKulit = binding.G7
        JumlahKotoranBanyak = binding.G8
        EkorBasah = binding.G9
        PenyumbatanUsus = binding.G10
        DudukMembungkuk = binding.G11
        TubuhTerasaDingin = binding.G12
        SakitPerut = binding.G13
        TidurDiSudutKandang = binding.G14
        BauMenyengat = binding.G15
        NafasTerengahEngah = binding.G16
        TidakNafsuMakan = binding.G17
        BAKBerdarah = binding.G18
        BergerakSangatLamban = binding.G19

        btnDiagnosa = binding.btnDiagnosa

        // Menambahkan listener pada tombol diagnosa
        btnDiagnosa.setOnClickListener {
            var namaPenyakit = ""

            // Memeriksa status checkbox dan menggabungkan nama penyakit yang sesuai dengan rule
            if (CairanHidung.isChecked && Bersin.isChecked
                && Lesu.isChecked && SakitPerut.isChecked && TidurDiSudutKandang.isChecked) {
                namaPenyakit += P1+ ", "
                Log.d("Check", namaPenyakit)
            }
            if (KotoranBerwarnaHijau.isChecked && KotoranEncer.isChecked
                && JumlahKotoranBanyak.isChecked && EkorBasah.isChecked) {
                namaPenyakit += P2+ ", "
                Log.d("Check", namaPenyakit)

            }
            if (Lesu.isChecked && SulitBernafas.isChecked && GatalPadaKulit.isChecked ) {
                namaPenyakit += P3+ ", "
                Log.d("Check", namaPenyakit)

            }
            if (Lesu.isChecked && BauMenyengat.isChecked) {
                namaPenyakit += P4+ ", "
                Log.d("Check", namaPenyakit)

            }
            if (Bersin.isChecked && DudukMembungkuk.isChecked && NafasTerengahEngah.isChecked) {
                namaPenyakit += P5+ ", "
                Log.d("Check", namaPenyakit)

            }
            if (EkorBasah.isChecked && TidakNafsuMakan.isChecked && BergerakSangatLamban.isChecked) {
                namaPenyakit += P6+ ", "
                Log.d("Check", namaPenyakit)

            }
            if (Lesu.isChecked && TidakNafsuMakan.isChecked && BAKBerdarah.isChecked ) {
                namaPenyakit += P7+ ", "
                Log.d("Check", namaPenyakit)

            }
            if (PenyumbatanUsus.isChecked && TubuhTerasaDingin.isChecked
                && TidakNafsuMakan.isChecked && BergerakSangatLamban.isChecked) {
                namaPenyakit += P8+ ", "
                Log.d("Check", namaPenyakit)

            }
            if (namaPenyakit.isNotEmpty()) {
                namaPenyakit = namaPenyakit.substring(0, namaPenyakit.length - 2)
            }else {
                namaPenyakit = "Penyakit yang tidak terdeteksi"
            }

            val bundle = Bundle()
            bundle.putString("diagnosa", namaPenyakit)
            findNavController().navigate(R.id.action_diagnoseFragment_to_resultFragment,bundle)
        }


        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Membersihkan binding saat view fragment dihancurkan
        _binding = null
    }

    // Function yang dipanggil saat fragment dibuat, digunakan untuk menangani tombol kembali
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Mengatur aksi tombol kembali untuk kembali ke fragment sebelumnya
        requireActivity().onBackPressedDispatcher.addCallback(this) {
            findNavController().navigateUp()
        }
    }
}
