package com.example.Home

import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.Home.pertemuan5.LimaActivity
import com.example.Home.pertemuan6.EnamActivity
import com.example.Home.pertemuan9.NinthActivity
import com.example.Home.pertemuan_10.TenthActivity
import com.example.LoginActivity
import com.example.gedeabhita.R
import com.example.gedeabhita.databinding.ActivityMainBinding
import com.example.gedeabhita.databinding.FragmentHomeBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.title = "Home"

        val sharedPref = requireContext().getSharedPreferences("user_pref", MODE_PRIVATE)
        val user = requireActivity().intent.getStringExtra("username")
        val pass = requireActivity().intent.getStringExtra("password")

        binding.txtUsername.text = user
        binding.txtPassword.setText(pass)

        binding.btnSnackBar.setOnClickListener {
            Snackbar.make(
                binding.root,"Halo ini Snackbar",
                Snackbar.LENGTH_LONG)
                .setAction("KEMBALI"){
                    val intent = Intent(requireActivity(), LoginActivity::class.java)
                    startActivity(intent)
                    Toast.makeText(requireContext(),"kembali ke Login Activity" , Toast.LENGTH_LONG).show()
                }
                .show()
        }
        binding.btnAlert.setOnClickListener {
            MaterialAlertDialogBuilder(requireActivity())
                .setTitle("Hapus data")
                .setMessage("Data yang dihapus tidak " +
                        "bisa dikembalikan.")
                .setNegativeButton("Batal", null)
                .setPositiveButton("Hapus") { dialog, _ ->


                    dialog.dismiss()
                }
                .setCancelable(false)
                .show()
        }
        binding.btnlima.setOnClickListener {
            startActivity(Intent (requireActivity(), LimaActivity::class.java))
        }

        binding.btnEnam.setOnClickListener {
            startActivity(Intent (requireContext(), EnamActivity::class.java))
        }

        binding.btnSembilan.setOnClickListener {
            startActivity(Intent(requireContext(), NinthActivity::class.java ))
        }

        binding.btnSepuluh.setOnClickListener {
            startActivity(Intent(requireContext(), TenthActivity::class.java ))
        }

        binding.btnLogout.setOnClickListener {
            AlertDialog.Builder(requireActivity())
                .setTitle("Logout")
                .setMessage("Apakah Anda yakin ingin keluar?")
                .setPositiveButton("Ya") { dialog, _ ->
                    val editor = sharedPref.edit()
                    editor.clear()
                    editor.apply()
                    dialog.dismiss()
                    startActivity(Intent(requireContext(), LoginActivity::class.java))
                    requireActivity()
                }
                .setNegativeButton("Batal") { dialog, _ -> dialog.dismiss() }
                .show()
        }


    }
    }


