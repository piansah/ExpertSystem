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
    // View holder untuk item-item dalam RecyclerView.
    class ViewHolder(val binding: DiseaseListBinding) : RecyclerView.ViewHolder(binding.root)

    // Membuat dan meng-inflate tampilan untuk setiap item dalam RecyclerView.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Meng-inflate layout untuk satu item menggunakan DiseaseListBinding.
        val view = DiseaseListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    // Mendapatkan total jumlah item dalam RecyclerView.
    override fun getItemCount(): Int {
        return DataDisease.size
    }

    // Mengikat data dari sumber data (DataDisease) ke tampilan ViewHolder.
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Set teks untuk tampilan 'txtNamaPenyakit' pada ViewHolder
        // menggunakan data yang sesuai dari daftar DataDisease.
        holder.binding.txtNamaPenyakit.text = DataDisease[position].penyakit

        // Mengatur onClickListener untuk setiap item dalam RecyclerView.
        holder.binding.cardView.setOnClickListener {
            // Membuat bundle untuk mengirim data ke fragment tujuan.
            val bundle = Bundle()
            bundle.putString("namaPenyakit", DataDisease[position].penyakit)
            bundle.putString("penjelasanPenyakit", DataDisease[position].penjelasanPenyakit)
            bundle.putString("penjelasanDiagnosa", DataDisease[position].penjelasanDiagnosa)
            bundle.putString("penjelasanPencegahan", DataDisease[position].penjelasanPencegahan)
            bundle.putString("penjelasanPerawatan", DataDisease[position].penjelasanPerawatan)

            // Navigasi ke fragment tujuan (detailFragment) dengan mengirimkan bundle sebagai argumen.
            findNavController(it).navigate(R.id.action_diseaseFragment_to_detailFragment, bundle)
        }
    }

    // Fungsi untuk memperbarui data dalam adapter RecyclerView.
    // Fungsi ini menghapus data yang sudah ada dan menggantinya dengan data baru yang disediakan (newData),
    // kemudian memberitahu adapter bahwa data telah berubah.
    @SuppressLint("NotifyDataSetChanged")
    fun setData(newData: ArrayList<MyDisease>) {
        // Menghapus data saat ini dalam daftar DataDisease.
        DataDisease.clear()
        // Menambahkan semua data baru dari newData ke dalam daftar DataDisease.
        DataDisease.addAll(newData)
        // Memberitahu adapter bahwa data telah berubah,
        // sehingga RecyclerView akan diperbarui dengan data baru.
        notifyDataSetChanged()
    }
}
