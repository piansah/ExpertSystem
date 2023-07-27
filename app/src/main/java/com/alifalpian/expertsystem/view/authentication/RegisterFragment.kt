package com.alifalpian.expertsystem.view.authentication

import android.app.DatePickerDialog
import androidx.fragment.app.Fragment
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.addCallback
import androidx.navigation.fragment.findNavController
import com.alifalpian.expertsystem.R
import com.alifalpian.expertsystem.databinding.FragmentRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class RegisterFragment : Fragment() {
    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!
    private lateinit var auth: FirebaseAuth
    private val calendar: Calendar = Calendar.getInstance()

    // Membuat tampilan fragment dengan meng-inflate layout FragmentRegisterBinding.
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    // Menyiapkan tampilan dan aksi onClick untuk tombol register dan inputDateOfBirth (Date Picker).
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        auth = Firebase.auth
        binding.btnRegister.setOnClickListener { createAccount() }
        binding.inputDateOfBirth.setOnClickListener { showDatePickerDialog() }
    }

    // Fungsi untuk membuat akun pengguna baru dengan email dan password.
    private fun createAccount() {
        val email = binding.inputEmail.text.toString()
        val password = binding.inputPassword.text.toString()

        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
            Toast.makeText(requireContext(), "Email dan password diperlukan", Toast.LENGTH_SHORT).show()
            return
        }

        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                Toast.makeText(requireContext(), "Register Berhasil", Toast.LENGTH_SHORT).show()
                navigateToLogin()
            } else {
                Toast.makeText(requireContext(), "Register Gagal", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Fungsi untuk melakukan navigasi ke halaman login setelah akun berhasil dibuat.
    private fun navigateToLogin() {
        findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
    }

    // Fungsi untuk menampilkan Date Picker Dialog saat inputDateOfBirth di klik.
    private fun showDatePickerDialog() {
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(requireContext(), { _, selectedYear, selectedMonth, selectedDay ->
            calendar.set(selectedYear, selectedMonth, selectedDay)
            val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
            val selectedDate = dateFormat.format(calendar.time)
            binding.inputDateOfBirth.setText(selectedDate)
        }, year, month, day)

        datePickerDialog.show()
    }

    // Menambahkan aksi ketika tombol back ditekan.
    // Ketika tombol back ditekan, fragment akan melakukan navigasi ke atas (navigateUp) menggunakan NavController.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireActivity().onBackPressedDispatcher.addCallback(this) {
            findNavController().navigateUp()
        }
    }

    // Membersihkan referensi view binding (_binding) ketika fragment dihancurkan.
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
