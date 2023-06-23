package com.alifalpian.expertsystem.view.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alifalpian.expertsystem.databinding.DiseaseListBinding
import com.alifalpian.expertsystem.model.MyDisease
import com.alifalpian.expertsystem.view.disease.DetailFragment
import com.bumptech.glide.Glide

class DiseaseViewAdapter(private val context : Context, private val listDisease : ArrayList<MyDisease>) : RecyclerView.Adapter<DiseaseViewAdapter.ViewHolder>() {
    class ViewHolder(val binding : DiseaseListBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = DiseaseListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listDisease.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.txtNama.text = listDisease[position].penyakit
        Glide.with(holder.itemView.context).load(listDisease[position].foto).into(holder.binding.images)
        holder.binding.CardView.setOnClickListener {
            val inten = Intent(context, DetailFragment::class.java)
            inten.putExtra("penyakit", listDisease[position].penyakit)
            inten.putExtra("penjelasanPenyakit", listDisease[position].penjelasanPenyakit)
            inten.putExtra("penjelasanPencegahan", listDisease[position].penjelasanPencegahan)
            inten.putExtra("penjelasanDiagnosis", listDisease[position].penjelasanDiagnosis)
            inten.putExtra("penjelasanPerawatan", listDisease[position].penjelasanPerawatan)
            inten.putExtra("foto", listDisease[position].foto)
            context.startActivity(inten)
//            val bundle = Bundle()
//            bundle.putString("penyakit", listDisease[position].penyakit)
//            findNavController().navigate(R.id.action_diagnoseFragment_to_resultFragment,bundle)
        }
    }
}