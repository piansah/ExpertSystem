package com.alifalpian.expertsystem.view.history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.alifalpian.expertsystem.adapter.DiagnoseAdapter
import com.alifalpian.expertsystem.adapter.DiseaseAdapter
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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHistoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = DiagnoseAdapter(ArrayList())
        binding.rvResult.adapter = adapter
        binding.rvResult.layoutManager = LinearLayoutManager(requireContext())

        databaseRef = FirebaseDatabase.getInstance().getReference("diagnose")
        databaseRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val DiagnoseList = ArrayList<MyDiagnose>()
                for (snapshot in dataSnapshot.children) {
                    val disease = snapshot.getValue(MyDiagnose::class.java)
                    disease?.let { DiagnoseList.add(it) }
                }
                adapter.setData(DiagnoseList)
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Handle database error
            }
        })
    }
}