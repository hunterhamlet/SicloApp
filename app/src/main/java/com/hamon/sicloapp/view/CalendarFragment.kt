package com.hamon.sicloapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.hamon.sicloapp.R
import com.hamon.sicloapp.databinding.FragmentCalendarBinding

class CalendarFragment : Fragment() {

    private val binding: FragmentCalendarBinding by lazy {
        FragmentCalendarBinding.inflate(LayoutInflater.from(context), null, false)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}
