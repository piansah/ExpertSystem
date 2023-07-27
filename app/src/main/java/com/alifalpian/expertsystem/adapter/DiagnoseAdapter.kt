package com.alifalpian.expertsystem.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alifalpian.expertsystem.databinding.ResultListBinding
import com.alifalpian.expertsystem.model.MyDiagnose

class DiagnoseAdapter(private val DataDiagnose: ArrayList<MyDiagnose>) : RecyclerView.Adapter<DiagnoseAdapter.ViewHolder>() {
    // View holder untuk item-item dalam RecyclerView.
    class ViewHolder(val binding: ResultListBinding) : RecyclerView.ViewHolder(binding.root)

    // Membuat dan meng-inflate tampilan untuk setiap item dalam RecyclerView.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Meng-inflate layout untuk satu item menggunakan ResultListBinding.
        val view = ResultListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    // Mendapatkan total jumlah item dalam RecyclerView.
    override fun getItemCount(): Int {
        return DataDiagnose.size
    }

    // Mengikat data dari sumber data (DataDiagnose) ke tampilan ViewHolder.
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Menetapkan teks untuk tampilan 'result' dan 'datetime' pada ViewHolder
        // menggunakan data yang sesuai dari daftar DataDiagnose.
        holder.binding.txtHasilDiagnosa.text = DataDiagnose[position].result
        holder.binding.txtTanggalDiagnosa.text = DataDiagnose[position].datetime
    }

    // Fungsi untuk memperbarui data dalam adapter RecyclerView.
    // Fungsi ini menghapus data yang sudah ada dan menggantinya dengan data baru yang disediakan (newData),
    // kemudian memberitahu adapter bahwa data telah berubah.
    @SuppressLint("NotifyDataSetChanged")
    fun setData(newData: ArrayList<MyDiagnose>) {
        // Menghapus data saat ini dalam daftar DataDiagnose.
        DataDiagnose.clear()
        // Menambahkan semua data baru dari newData ke dalam daftar DataDiagnose.
        DataDiagnose.addAll(newData)
        // Memberitahu adapter bahwa data telah berubah,
        // sehingga RecyclerView akan diperbarui dengan data baru.
        notifyDataSetChanged()
    }
}
