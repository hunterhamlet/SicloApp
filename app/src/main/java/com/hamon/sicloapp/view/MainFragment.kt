package com.hamon.sicloapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.hamon.sicloapp.R
import com.hamon.sicloapp.databinding.FragmentMainBinding
import org.koin.android.ext.android.inject

class MainFragment : Fragment() {

    private val binding: FragmentMainBinding by lazy {
        FragmentMainBinding.inflate(LayoutInflater.from(context), null, false)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?)
            : View? =  binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupClickListener()
    }

    private fun setupClickListener(){
        binding.apply {
            buttonRegister.setOnClickListener {
                findNavController().navigate(R.id.action_mainFragment_to_registerFragment)
            }
            buttonLogin.setOnClickListener {
                findNavController().navigate(R.id.action_mainFragment_to_loginFragment)
            }
        }
    }

}
