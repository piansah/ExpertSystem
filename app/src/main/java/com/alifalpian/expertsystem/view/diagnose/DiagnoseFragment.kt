package com.alifalpian.expertsystem.view.diagnose

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.alifalpian.expertsystem.R
import com.alifalpian.expertsystem.databinding.FragmentDiagnoseBinding
import com.google.firebase.database.FirebaseDatabase
import java.text.SimpleDateFormat
import java.util.*

class DiagnoseFragment : Fragment() {
    private var _binding: FragmentDiagnoseBinding? = null
    private val binding get() = _binding!!

    private lateinit var penglihatanTerasaKabur : CheckBox
    private lateinit var mataBerair : CheckBox
    private lateinit var mataBengkak : CheckBox
    private lateinit var mataTerasaPerih : CheckBox
    private lateinit var mataTerasaAdaYangMengganjal : CheckBox
    private lateinit var penglihatanSilau : CheckBox
    private lateinit var terlihatLingkaranCahaya : CheckBox
    private lateinit var penglihatanObjekGanda : CheckBox
    private lateinit var mataBerwarnaMerah : CheckBox
    private lateinit var mataTerasaGatal : CheckBox
    private lateinit var mataTerasaPanas : CheckBox
    private lateinit var sakitKepala : CheckBox
    private lateinit var mataTerasaSakit : CheckBox
    private lateinit var mataMeradang : CheckBox
    private lateinit var mataNyeriHebat : CheckBox
    private lateinit var mataTerasaNyeri : CheckBox
    private lateinit var mataLelah : CheckBox
    private lateinit var kelainanPadaPupilMata : CheckBox
    private lateinit var seringMengedipkanMata : CheckBox
    private lateinit var pekaTerhadapCahaya : CheckBox
    private lateinit var penglihatanDekatTerasaKabur : CheckBox
    private lateinit var tekananBolaMataMeningkat : CheckBox
    private lateinit var penglihatanObjekJauhKurangTerlihatJelas : CheckBox
    private lateinit var lemakMenutupiKornea : CheckBox
    private lateinit var menyipitkanMataUntukMelihatBendaYangDekat : CheckBox
    private lateinit var sumberCahayaAkanBerwarnaPelangiJikaMelihatCahayaYangTerang : CheckBox
    private lateinit var mataTegang : CheckBox
    private lateinit var terlihatBayanganGarisHitam : CheckBox
    private lateinit var btnDiagnosa : Button

    //daftar penyakit
    private val P1 = "Katarak"
    private val P2 = "DryEye (MataKering)"
    private val P3 = "Glaukoma"
    private val P4 = "Keratitis"
    private val P5 = "Myopia"
    private val P6 = "Pterygium"
    private val P7 = "Hypermetropi"
    private val P8 = "Astigmatisma"

    // Membuat tampilan fragment dengan meng-inflate layout FragmentDiagnoseBinding.
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDiagnoseBinding.inflate(inflater, container, false)
        val view = binding.root

        // Inisialisasi Firebase Realtime Database
        val database = FirebaseDatabase.getInstance()
        val diagnosaRef = database.reference.child("diagnose")

        // Inisialisasi elemen-elemen tampilan checkbox dan button di layout.
        penglihatanTerasaKabur = binding.G1
        mataBerair = binding.G2
        mataBengkak = binding.G3
        mataTerasaPerih = binding.G4
        mataTerasaAdaYangMengganjal = binding.G5
        penglihatanSilau = binding.G6
        terlihatLingkaranCahaya = binding.G7
        penglihatanObjekGanda = binding.G8
        mataBerwarnaMerah = binding.G9
        mataTerasaGatal = binding.G10
        mataTerasaPanas = binding.G11
        sakitKepala = binding.G12
        mataTerasaSakit = binding.G13
        mataMeradang = binding.G14
        mataNyeriHebat = binding.G15
        mataTerasaNyeri = binding.G16
        kelainanPadaPupilMata = binding.G17
        mataLelah = binding.G18
        seringMengedipkanMata = binding.G19
        pekaTerhadapCahaya = binding.G20
        penglihatanDekatTerasaKabur = binding.G21
        tekananBolaMataMeningkat = binding.G22
        penglihatanObjekJauhKurangTerlihatJelas = binding.G23
        lemakMenutupiKornea = binding.G24
        menyipitkanMataUntukMelihatBendaYangDekat = binding.G25
        sumberCahayaAkanBerwarnaPelangiJikaMelihatCahayaYangTerang = binding.G26
        mataTegang = binding.G27
        terlihatBayanganGarisHitam = binding.G28

        btnDiagnosa = binding.btnDiagnosa

        // Aksi ketika tombol Diagnosa ditekan.
        btnDiagnosa.setOnClickListener {
            var namaPenyakit = ""

            // Proses pengecekan gejala pada checkbox dan menambahkan nama penyakit ke variabel namaPenyakit.
            if (penglihatanTerasaKabur.isChecked && penglihatanObjekGanda.isChecked && mataTerasaNyeri.isChecked && terlihatBayanganGarisHitam.isChecked) {
                namaPenyakit += "$P1, "
                Log.d("Check", namaPenyakit)
            }
            if (mataTerasaAdaYangMengganjal.isChecked && pekaTerhadapCahaya.isChecked) {
                namaPenyakit += "$P2, "
                Log.d("Check", namaPenyakit)

            }
            if (mataTerasaSakit.isChecked && kelainanPadaPupilMata.isChecked
                && tekananBolaMataMeningkat.isChecked && sumberCahayaAkanBerwarnaPelangiJikaMelihatCahayaYangTerang.isChecked) {
                namaPenyakit += "$P3, "
                Log.d("Check", namaPenyakit)

            }
            if (mataBerair.isChecked && mataBengkak.isChecked && mataTerasaGatal.isChecked
                && mataTerasaPanas.isChecked && mataTerasaNyeri.isChecked) {
                namaPenyakit += "$P4, "
                Log.d("Check", namaPenyakit)

            }
            if (sakitKepala.isChecked && mataLelah.isChecked && seringMengedipkanMata.isChecked
                && penglihatanObjekJauhKurangTerlihatJelas.isChecked) {
                namaPenyakit += "$P5, "
                Log.d("Check", namaPenyakit)

            }
            if (mataBerair.isChecked && mataBerwarnaMerah.isChecked && lemakMenutupiKornea.isChecked) {
                namaPenyakit += "$P6, "
                Log.d("Check", namaPenyakit)

            }
            if (sakitKepala.isChecked && penglihatanDekatTerasaKabur.isChecked
                && menyipitkanMataUntukMelihatBendaYangDekat.isChecked) {
                namaPenyakit += "$P7, "
                Log.d("Check", namaPenyakit)

            }
            if (mataTegang.isChecked && penglihatanTerasaKabur.isChecked) {
                namaPenyakit += "$P8, "
                Log.d("Check", namaPenyakit)
            }

            if (namaPenyakit.isNotEmpty()) {
                namaPenyakit = namaPenyakit.substring(0, namaPenyakit.length - 2)
            }else {
                // Jika tidak ada nama penyakit yang terdeteksi, set namaPenyakit sebagai "Penyakit tidak terdeteksi".
                namaPenyakit = "Penyakit tidak terdeteksi"
            }

            // Navigasi ke halaman ResultFragment dan mengirimkan data namaPenyakit melalui bundle.
            val bundle = Bundle()
            bundle.putString("diagnosa", namaPenyakit)
            findNavController().navigate(R.id.action_diagnoseFragment_to_resultFragment,bundle)

            // Menyimpan hasil diagnosa ke Firebase Realtime Database bersama dengan waktu dan tanggal.
            val dateTime = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(Date())
            val diagnosaData = HashMap<String, Any>()
            diagnosaData["result"] = namaPenyakit
            diagnosaData["datetime"] = dateTime

            diagnosaRef.push().setValue(diagnosaData)
                .addOnSuccessListener {
                    Toast.makeText(requireContext(), "Diagnosa berhasil disimpan", Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener {
                    Toast.makeText(requireContext(), "Gagal menyimpan diagnosa", Toast.LENGTH_SHORT).show()
                }
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
