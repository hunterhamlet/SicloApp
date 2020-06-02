package com.hamon.sicloapp.view

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController

import com.hamon.sicloapp.R
import com.hamon.sicloapp.databinding.FragmentRegisterBinding
import com.hamon.sicloapp.viewmodel.RegisterViewModel
import org.koin.android.ext.android.inject

class RegisterFragment : Fragment() {

    private val binding: FragmentRegisterBinding by lazy {
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
        addTextWatcher()
    }

    private fun setupClickListener() {
        binding.apply {
            buttonContinue.setOnClickListener {
                if (checkIfFieldNotNull()) {
                    viewModel.saveInfoUser(
                        name = inputNames.text.toString(),
                        firstName = inputLastName.text.toString(),
                        secondLastName = inputSecondLastName.text.toString(),
                        email = inputUserEmail.text.toString(),
                        password = inputUserPass.text.toString()
                    )
                    Toast.makeText(
                        context,
                        resources.getString(R.string.user_register_success),
                        Toast.LENGTH_SHORT
                    )
                        .show()
                    findNavController().navigate(R.id.action_registerFragment_to_calendarFragment)
                }
            }
        }
    }

    private fun checkIfFieldNotNull(): Boolean {
        var isNotNullAllFields = true
        binding.apply {
            if (inputNames.text.toString().isNotEmpty() &&
                inputLastName.text.toString().isNotEmpty() &&
                inputSecondLastName.text.toString().isNotEmpty() &&
                inputUserEmail.text.toString().isNotEmpty() &&
                inputUserPass.text.toString().isNotEmpty()
            ) {
                isNotNullAllFields = true
            } else if (inputNames.text.toString().isEmpty()) {
                inputLayoutNames.error = resources.getString(R.string.field_empty)
                isNotNullAllFields = false
            } else if (inputLastName.text.toString().isEmpty()) {
                inputLayoutLastName.error = resources.getString(R.string.field_empty)
                isNotNullAllFields = false
            } else if (inputSecondLastName.text.toString().isEmpty()) {
                inputLayoutSecondLastName.error = resources.getString(R.string.field_empty)
                isNotNullAllFields = false
            } else if (inputUserEmail.text.toString().isEmpty()) {
                inputLayoutUserEmail.error = resources.getString(R.string.field_empty)
                isNotNullAllFields = false
            } else if (inputUserPass.text.toString().isEmpty()) {
                inputLayoutUserPass.error = resources.getString(R.string.field_empty)
                isNotNullAllFields = false
            }
        }
        return isNotNullAllFields
    }

    private fun addTextWatcher() {
        binding.apply {
            inputNames.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(s: Editable?) {}

                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    inputLayoutNames.error = null
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            })
            inputLastName.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(s: Editable?) {}

                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    inputLayoutLastName.error = null
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            })
            inputSecondLastName.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(s: Editable?) {}

                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    inputLayoutSecondLastName.error = null
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            })
            inputUserEmail.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(s: Editable?) {}

                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    inputLayoutUserEmail.error = null
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            })
            inputUserPass.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(s: Editable?) {}

                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    inputLayoutUserPass.error = null
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            })
        }
    }


}
