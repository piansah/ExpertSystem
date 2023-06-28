package com.alifalpian.expertsystem.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.alifalpian.expertsystem.R
import com.alifalpian.expertsystem.databinding.DiseaseListBinding
import com.alifalpian.expertsystem.model.MyDisease
import com.bumptech.glide.Glide

class DiseaseViewAdapter(private val listDisease: ArrayList<MyDisease>) : RecyclerView.Adapter<DiseaseViewAdapter.ViewHolder>() {
    class ViewHolder(val binding: DiseaseListBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = DiseaseListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listDisease.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.txtNamaPenyakit.text = listDisease[position].penyakit
        Glide.with(holder.itemView.context).load(listDisease[position].foto).into(holder.binding.images)
        holder.binding.CardView.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("penyakit", listDisease[position].penyakit)
            bundle.putString("penjelasanPenyakit", listDisease[position].penjelasanPenyakit)
            bundle.putString("penjelasanPencegahan", listDisease[position].penjelasanPencegahan)
            bundle.putString("penjelasanDiagnosis", listDisease[position].penjelasanDiagnosis)
            bundle.putString("penjelasanPerawatan", listDisease[position].penjelasanPerawatan)
            bundle.putString("foto", listDisease[position].foto)
            findNavController(it).navigate(R.id.action_diseaseFragment_to_detailFragment, bundle)


        }
    }
}
