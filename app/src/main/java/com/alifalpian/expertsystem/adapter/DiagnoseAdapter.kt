package com.alifalpian.expertsystem.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alifalpian.expertsystem.databinding.ResultListBinding
import com.alifalpian.expertsystem.model.MyDiagnose

class DiagnoseAdapter(private val DataDiagnose: ArrayList<MyDiagnose>) : RecyclerView.Adapter<DiagnoseAdapter.ViewHolder>() {
    class ViewHolder(val binding: ResultListBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ResultListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return DataDiagnose.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.txtHasilDiagnosa.text = DataDiagnose[position].result
        holder.binding.txtTanggalDiagnosa.text = DataDiagnose[position].datetime

    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(newData: ArrayList<MyDiagnose>) {
        DataDiagnose.clear()
        DataDiagnose.addAll(newData)
        notifyDataSetChanged()
    }
}

