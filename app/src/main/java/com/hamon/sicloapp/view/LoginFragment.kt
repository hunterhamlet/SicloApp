package com.hamon.sicloapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController

import com.hamon.sicloapp.R
import com.hamon.sicloapp.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private val binding: FragmentLoginBinding by lazy {
        FragmentLoginBinding.inflate(LayoutInflater.from(context), null, false)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setClickListener()
    }

    private fun setClickListener(){
        binding.apply {
            buttonLogin.setOnClickListener {
                findNavController().navigate(R.id.action_loginFragment_to_calendarFragment)
            }
        }
    }

}
