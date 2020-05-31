package com.hamon.sicloapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController

import com.hamon.sicloapp.R
import com.hamon.sicloapp.databinding.FragmentLoginBinding
import com.hamon.sicloapp.viewmodel.LoginViewModel
import org.koin.android.ext.android.inject

class LoginFragment : Fragment() {

    private val binding: FragmentLoginBinding by lazy {
        FragmentLoginBinding.inflate(LayoutInflater.from(context), null, false)
    }
    private val viewModel: LoginViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setClickListener()
        setObservable()
    }

    private fun setClickListener(){
        binding.apply {
            buttonLogin.setOnClickListener {
                viewModel.checkUserEmailAndPass(inputUserEmail.text.toString(), inputUserPass.text.toString())
            }
        }
    }

    private fun setObservable(){
        viewModel.isNewUserObservable.observe(viewLifecycleOwner, Observer {isUserRegister ->
            if (isUserRegister){
                findNavController().navigate(R.id.action_loginFragment_to_calendarFragment)
            }else{
                Toast.makeText(context, "Usuario o contraseña erróneos", Toast.LENGTH_SHORT).show()
            }
        })
    }

}
