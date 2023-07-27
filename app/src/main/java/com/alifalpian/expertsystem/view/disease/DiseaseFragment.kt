package com.alifalpian.expertsystem.view.disease

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.alifalpian.expertsystem.adapter.DiseaseAdapter
import com.alifalpian.expertsystem.databinding.FragmentDiseaseBinding
import com.alifalpian.expertsystem.model.MyDisease
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class DiseaseFragment : Fragment() {
    private lateinit var binding: FragmentDiseaseBinding
    private lateinit var adapter: DiseaseAdapter
    private lateinit var databaseRef: DatabaseReference

    // Membuat tampilan fragment dengan meng-inflate layout FragmentDiseaseBinding.
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDiseaseBinding.inflate(inflater, container, false)
        return binding.root
    }

    // Mengisi tampilan dengan data dari Firebase dan menampilkan daftar penyakit dengan menggunakan RecyclerView.
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inisialisasi adapter untuk RecyclerView.
        adapter = DiseaseAdapter(ArrayList())
        binding.rvDisease.adapter = adapter
        binding.rvDisease.layoutManager = LinearLayoutManager(requireContext())

        // Mendapatkan referensi database dari Firebase.
        databaseRef = FirebaseDatabase.getInstance().getReference("Disease")
        databaseRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // Membuat daftar penyakit (DiseaseList) berdasarkan data yang ada di Firebase.
                val DiseaseList = ArrayList<MyDisease>()
                for (snapshot in dataSnapshot.children) {
                    val disease = snapshot.getValue(MyDisease::class.java)
                    disease?.let { DiseaseList.add(it) }
                }

                // Mengupdate data dalam adapter dengan daftar penyakit yang baru.
                adapter.setData(DiseaseList)
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Aksi yang diambil jika ada pembacaan data dari Firebase yang dibatalkan (misalnya, koneksi gagal).
                // Tidak ada tindakan khusus yang diambil di sini, namun Anda dapat menambahkan log atau tindakan lain sesuai kebutuhan.
            }
        })
    }
}
