package com.alifalpian.expertsystem.adapter

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.alifalpian.expertsystem.R
import com.alifalpian.expertsystem.databinding.DiseaseListBinding
import com.alifalpian.expertsystem.model.MyDisease

class DiseaseAdapter(private val DataDisease: ArrayList<MyDisease>) : RecyclerView.Adapter<DiseaseAdapter.ViewHolder>() {
    class ViewHolder(val binding: DiseaseListBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = DiseaseListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return DataDisease.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.txtNamaPenyakit.text = DataDisease[position].penyakit
//        Glide.with(holder.itemView.context).load(DataDisease[position].foto).into(holder.binding.images)

        holder.binding.cardView.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("namaPenyakit", DataDisease[position].penyakit)
            bundle.putString("penjelasanPenyakit", DataDisease[position].penjelasanPenyakit)
            bundle.putString("penjelasanDiagnosa", DataDisease[position].penjelasanDiagnosa)
            bundle.putString("penjelasanPencegahan", DataDisease[position].penjelasanPencegahan)
            bundle.putString("penjelasanPerawatan", DataDisease[position].penjelasanPerawatan)
            findNavController(it).navigate(R.id.action_diseaseFragment_to_detailFragment, bundle)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(newData: ArrayList<MyDisease>) {
        DataDisease.clear()
        DataDisease.addAll(newData)
        notifyDataSetChanged()
    }
}

