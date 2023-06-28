package com.alifalpian.expertsystem.view.authentication

import android.content.Context
import android.content.SharedPreferences
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
import com.alifalpian.expertsystem.databinding.FragmentLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginFragment : Fragment(), View.OnClickListener {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private lateinit var auth: FirebaseAuth
    private lateinit var sharedPrefs: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            btnLogin.setOnClickListener(this@LoginFragment)
            btnRegister.setOnClickListener(this@LoginFragment)
        }

        auth = Firebase.auth
        sharedPrefs = requireContext().getSharedPreferences("DataUser", Context.MODE_PRIVATE)

//        // Cek apakah pengguna telah login sebelumnya
//        if (sharedPrefs.contains("user_id")) {
//            val userId = sharedPrefs.getInt("user_id", 0)
//            if (userId != 0) {
//                findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
//            }
//        }
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btnLogin -> signIn(
                binding.inputEmail.text.toString(),
                binding.inputPassword.text.toString()
            )

            R.id.btnRegister -> findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }
    }

    private fun signIn(email: String, password: String) {
        if (!validateForm()) {
            return
        }

        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(requireActivity()) { task ->
                if (task.isSuccessful) {
                    // Simpan informasi pengguna dalam SharedPreferences
                    with(sharedPrefs.edit()){
                        putInt("user_id", 1)
                        apply()
                    }
                    Toast.makeText(requireContext(), "Authentication successful", Toast.LENGTH_SHORT).show()
                    findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
                } else {
                    Toast.makeText(requireContext(), "Authentication failed", Toast.LENGTH_SHORT).show()
                }
            }
    }

    private fun validateForm(): Boolean {
        var valid = true
        val email = binding.inputEmail.text.toString()
        if (TextUtils.isEmpty(email)) {
            binding.inputEmail.error = "Required."
            valid = false
        } else {
            binding.inputEmail.error = null
        }
        val password = binding.inputPassword.text.toString()
        if (TextUtils.isEmpty(password)) {
            binding.inputPassword.error = "Required."
            valid = false
        } else {
            binding.inputPassword.error = null
        }
        return valid
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

