package com.alifalpian.expertsystem.view.disease

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.alifalpian.expertsystem.adapter.DiseaseViewAdapter
import com.alifalpian.expertsystem.databinding.FragmentDiseaseBinding
import com.alifalpian.expertsystem.model.MyDisease

class DiseaseFragment : Fragment() {
    private var _binding: FragmentDiseaseBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDiseaseBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val listDisease = arrayListOf(
            MyDisease(
                "Salesma",
                "Salesma pada hamster adalah penyakit pernapasan yang umum terjadi pada mereka. Penyakit ini bisa disebabkan oleh infeksi virus seperti virus Sendai atau virus corona, serta infeksi bakteri. Gejalanya meliputi bersin, batuk, hidung berair, mata merah atau berair, sesak napas, dan penurunan nafsu makan.",
                "Jaga kebersihan lingkungan kandang hamster, hindari kontak dengan hamster yang terinfeksi, dan vaksinasi yang tepat.",
                "Pemeriksaan klinis oleh dokter hewan berpengalaman, serta tes laboratorium jika diperlukan.",
                "Perawatan simtomatik, seperti menjaga kebersihan kandang, memberikan makanan yang bergizi, dan pemberian obat-obatan yang diresepkan oleh dokter hewan.",
                "https://raw.githubusercontent.com/piansah/ExpertSystem/master/app/src/main/res/drawable/hamster_a.jpg"
            ),
            MyDisease(
                "Diare",
                "Diare pada hamster terjadi ketika tinja menjadi encer atau berair. Penyebab diare bisa bervariasi, termasuk infeksi bakteri, infeksi parasit, perubahan makanan yang tiba-tiba, stres, atau masalah pencernaan. Gejalanya meliputi frekuensi buang air besar yang meningkat, tinja berwarna terang atau berdarah, penurunan nafsu makan, dan kelelahan.",
                "Jaga kebersihan kandang hamster, hindari perubahan makanan yang tiba-tiba, dan pastikan hamster mendapatkan makanan yang seimbang.",
                "Pemeriksaan tinja dan pemeriksaan klinis oleh dokter hewan.",
                "Pemberian makanan yang mudah dicerna, cairan elektrolit untuk menghindari dehidrasi, dan pengobatan sesuai dengan penyebab yang mendasari.",
                "https://raw.githubusercontent.com/piansah/ExpertSystem/master/app/src/main/res/drawable/hamster_b.jpg"
            ),
            MyDisease(
                "Diare (Jamur)",
                "Diare yang disebabkan oleh infeksi jamur pada hamster dapat terjadi akibat spesies jamur seperti Candida spp. atau Aspergillus spp. Gejalanya meliputi diare dengan tinja berwarna coklat atau hijau tua, penurunan nafsu makan, kehilangan berat badan, kelemahan, dan perubahan pada kulit atau rambut.",
                "Jaga kebersihan kandang hamster, pastikan sirkulasi udara yang baik, dan hindari kontaminasi makanan.",
                "Pemeriksaan tinja, pemeriksaan kulit atau rambut yang bermasalah, dan tes laboratorium jika diperlukan.",
                "Pengobatan antijamur yang diresepkan oleh dokter hewan, perbaikan kebersihan kandang, dan pemberian makanan yang sehat.",
                "https://raw.githubusercontent.com/piansah/ExpertSystem/master/app/src/main/res/drawable/hamster_c.jpg"
            ),
            MyDisease(
                "Diare (Bakteri)",
                "Diare pada hamster yang disebabkan oleh infeksi bakteri bisa terjadi akibat konsumsi makanan atau air yang terkontaminasi bakteri patogen seperti Salmonella spp. atau Campylobacter spp. Gejalanya meliputi tinja berair, penurunan nafsu makan, kelelahan, dan mungkin juga demam.",
                "Jaga kebersihan kandang hamster, pastikan kebersihan makanan dan air minum, serta hindari kontak dengan hewan yang terinfeksi.",
                "Pemeriksaan tinja dan pemeriksaan klinis oleh dokter hewan.",
                "Pengobatan antibiotik yang diresepkan oleh dokter hewan, perbaikan kebersihan kandang, dan pemberian makanan yang bergizi.",
                "https://raw.githubusercontent.com/piansah/ExpertSystem/master/app/src/main/res/drawable/hamster_d.jpg"
            ),
            MyDisease(
                "Flu Hamster",
                "Flu pada hamster, juga dikenal sebagai penyakit pernapasan atas, sering disebabkan oleh infeksi virus seperti virus Sendai. Gejala yang muncul meliputi bersin, batuk, hidung berair, mata merah atau berair, penurunan nafsu makan, kelesuan, dan penurunan aktivitas. Infeksi virus flu dapat menyebar dengan cepat antara hamster yang hidup dalam kelompok atau koloni.",
                "Jaga kebersihan kandang hamster, hindari kontak dengan hamster yang terinfeksi, dan isolasi hamster yang sakit untuk mencegah penyebaran infeksi.",
                "Pemeriksaan klinis oleh dokter hewan berpengalaman dan tes laboratorium jika diperlukan.",
                "Perawatan simtomatik, seperti menjaga kebersihan kandang, memberikan makanan yang bergizi, dan pemberian obat-obatan yang diresepkan oleh dokter hewan untuk mengurangi gejala.",
                "https://raw.githubusercontent.com/piansah/ExpertSystem/master/app/src/main/res/drawable/hamster_e.jpg"
            ),
            MyDisease(
                "Ekor Basah",
                "Ekor Basah atau \"Wet Tail\" adalah penyakit serius yang mempengaruhi saluran pencernaan hamster. Penyakit ini umumnya disebabkan oleh infeksi bakteri Lawsonia intracellularis. Gejala yang muncul termasuk diare berair yang parah, tinja berbau busuk, kehilangan nafsu makan, kelelahan, dehidrasi, dan ekor yang tampak basah akibat kelebihan cairan.",
                "Jaga kebersihan kandang hamster, hindari stres yang berlebihan, dan berikan makanan yang seimbang.",
                "Pemeriksaan klinis oleh dokter hewan berpengalaman dan tes laboratorium untuk mengidentifikasi bakteri penyebab.",
                "Pengobatan dengan antibiotik yang diresepkan oleh dokter hewan, perawatan simtomatik untuk mengatasi dehidrasi dan kehilangan nafsu makan, serta menjaga kebersihan kandang dengan lebih intensif.",
                "https://raw.githubusercontent.com/piansah/ExpertSystem/master/app/src/main/res/drawable/hamster_f.png"
            ),
            MyDisease(
                "Sembelit",
                "Sembelit pada hamster terjadi ketika mereka mengalami kesulitan atau tidak mampu buang air besar secara teratur. Penyebab sembelit bisa beragam, termasuk kurangnya serat dalam makanan, dehidrasi, atau adanya penyumbatan saluran pencernaan. Gejala yang mungkin terjadi meliputi kurangnya frekuensi buang air besar, tinja yang keras atau kering, perut bengkak, dan kurangnya nafsu makan.",
                "Pastikan hamster mendapatkan makanan yang mengandung serat yang cukup, berikan akses ke air minum yang bersih dan segar, serta hindari pakan yang terlalu kering.",
                "Pemeriksaan klinis oleh dokter hewan dan pemeriksaan tinja jika diperlukan.",
                "Meningkatkan serat dalam makanan hamster, memastikan mereka terhidrasi dengan baik, dan memberikan perawatan simtomatik seperti minyak mineral atau pencahar yang disarankan oleh dokter hewan.",
                "https://raw.githubusercontent.com/piansah/ExpertSystem/master/app/src/main/res/drawable/hamster_g.jpg"
            ),
            MyDisease(
                "Batu Ginjal",
                "Batu ginjal dapat terjadi pada hamster ketika endapan mineral mengkristal dalam saluran kemih dan membentuk batu di dalam ginjal. Hal ini dapat mengganggu fungsi ginjal dan menyebabkan gejala seperti nyeri perut, kelemahan, penurunan nafsu makan, diare, muntah, atau kesulitan buang air kecil. Penyebab pasti pembentukan batu ginjal pada hamster belum sepenuhnya dipahami, namun faktor seperti keturunan, dehidrasi, dan makanan yang tidak seimbang dapat berperan dalam perkembangan kondisi ini.",
                "Pastikan hamster selalu terhidrasi dengan baik, berikan makanan yang sehat dan seimbang, serta hindari kelebihan mineral dalam pakan.",
                "Pemeriksaan klinis oleh dokter hewan berpengalaman, pemeriksaan radiologi, dan tes laboratorium jika diperlukan.",
                "Perawatan tergantung pada ukuran dan lokasi batu ginjal, dapat meliputi pemberian obat untuk menghancurkan batu, pembedahan untuk mengangkat batu yang besar, atau perubahan diet yang disarankan oleh dokter hewan.",
                "https://raw.githubusercontent.com/piansah/ExpertSystem/master/app/src/main/res/drawable/kambing_putih.jpg"
            ),
        )
        setupRecyclerView(listDisease)
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

    private fun setupRecyclerView(diseaseList: ArrayList<MyDisease>) {
        val adapter = DiseaseViewAdapter(diseaseList)
        binding.rvDisease.layoutManager = LinearLayoutManager(requireContext())
        binding.rvDisease.adapter = adapter
    }
}
