package com.hamon.sicloapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController

import com.hamon.sicloapp.R
import com.hamon.sicloapp.databinding.FragmentRegisterBinding
import com.hamon.sicloapp.viewmodel.RegisterViewModel
import org.koin.android.ext.android.inject

class RegisterFragment : Fragment() {

    private val binding : FragmentRegisterBinding by lazy {
        FragmentRegisterBinding.inflate(LayoutInflater.from(context), null, false)
    }
    private val viewModel: RegisterViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupClickListener()
    }

    private fun setupClickListener(){
        binding.apply {
            buttonContinue.setOnClickListener {
                /*
                viewModel.saveInfoUser(
                    name = inputNames.text.toString(),
                    firstName = inputLastName.text.toString(),
                    secondLastName = inputSecondLastName.text.toString(),
                    email = inputUserEmail.text.toString(),
                    password = inputUserPass.text.toString()
                )
                */
                findNavController().navigate(R.id.action_registerFragment_to_calendarFragment)
            }
        }
    }


}
