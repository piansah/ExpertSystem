package com.alifalpian.expertsystem.view.history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.alifalpian.expertsystem.adapter.DiagnoseAdapter
import com.alifalpian.expertsystem.databinding.FragmentHistoryBinding
import com.alifalpian.expertsystem.model.MyDiagnose
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class HistoryFragment : Fragment() {
    private lateinit var binding: FragmentHistoryBinding
    private lateinit var adapter: DiagnoseAdapter
    private lateinit var databaseRef: DatabaseReference

    // Membuat tampilan fragment dengan meng-inflate layout FragmentHistoryBinding.
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHistoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    // Membuat tampilan hasil diagnosa dengan menggunakan adapter DiagnoseAdapter dan menampilkan hasil diagnosa berupa daftar riwayat diagnosa pengguna.
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = DiagnoseAdapter(ArrayList())
        binding.rvResult.adapter = adapter
        binding.rvResult.layoutManager = LinearLayoutManager(requireContext())

        // Mengakses database Firebase untuk mendapatkan riwayat diagnosa pengguna dari node "diagnose".
        databaseRef = FirebaseDatabase.getInstance().getReference("diagnose")
        databaseRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val DiagnoseList = ArrayList<MyDiagnose>()
                for (snapshot in dataSnapshot.children) {
                    val diagnose = snapshot.getValue(MyDiagnose::class.java)
                    diagnose?.let { DiagnoseList.add(it) }
                }
                DiagnoseList.sortByDescending { it.datetime }
                adapter.setData(DiagnoseList)
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Meng-handle error yang terjadi ketika mengakses database.
            }
        })
    }
}
