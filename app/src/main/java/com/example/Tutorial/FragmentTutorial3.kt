package com.example.Tutorial

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.LoginActivity
import com.example.gedeabhita.R
import com.example.gedeabhita.databinding.FragmentHomeBinding
import com.example.gedeabhita.databinding.FragmentTutorial3Binding


class FragmentTutorial3 : Fragment() {

    private var _binding: FragmentTutorial3Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentTutorial3Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.btnLogin.setOnClickListener{
            startActivity(Intent(requireContext(), LoginActivity::class.java))
        }
    }

}