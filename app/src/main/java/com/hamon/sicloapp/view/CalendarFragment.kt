package com.hamon.sicloapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.google.android.material.dialog.MaterialAlertDialogBuilder

import com.hamon.sicloapp.R
import com.hamon.sicloapp.adapters.CalendarDaysAdapter
import com.hamon.sicloapp.adapters.SicloClassAdapter
import com.hamon.sicloapp.databinding.FragmentCalendarBinding
import com.hamon.sicloapp.models.SicloClass
import com.hamon.sicloapp.viewmodel.CalendarViewModel
import kotlinx.android.synthetic.main.fragment_calendar.*
import org.koin.android.ext.android.inject
import timber.log.Timber

class CalendarFragment : Fragment() {

    private val binding: FragmentCalendarBinding by lazy {
        FragmentCalendarBinding.inflate(LayoutInflater.from(context), null, false)
    }
    private val viewModel: CalendarViewModel by inject()
    private val daysAdapter: CalendarDaysAdapter by lazy {
        CalendarDaysAdapter { dayClicked -> dayClicked(dayClicked) }
    }
    private val eventsAdapter: SicloClassAdapter by lazy {
        SicloClassAdapter{ sicloclass -> showDialog(sicloclass) }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setObservables()
        setupRecyclers()
    }

    private fun setObservables(){
        viewModel.listOfDays.observe(viewLifecycleOwner, Observer {listOfDays ->
            daysAdapter.addDays(listOfDays)
        })
        viewModel.userName.observe(viewLifecycleOwner, Observer {userName ->
            binding.welcomeTitle.text = getString(R.string.welcomeUser, userName.capitalize())
        })
        viewModel.listEvents.observe(viewLifecycleOwner, Observer {listEvents ->
            eventsAdapter.addEvents(listEvents)
        })
    }

    private fun dayClicked(dayClicked: String){
        viewModel.getListEvents(dayClicked)
    }

    private fun setupRecyclers(){
        binding.apply {
            recyclerDays.adapter = daysAdapter
            recyclerClases.adapter = eventsAdapter
        }
    }

    private fun showDialog(sicloClass: SicloClass){
        MaterialAlertDialogBuilder(requireContext())
            .setTitle(resources.getString(R.string.inscription_title))
            .setMessage(resources.getString(R.string.inscription_message,
                sicloClass.tipo,
                sicloClass.instructor.nombre,
                sicloClass.hour,
                sicloClass.duration.toString(),
                sicloClass.intensity.toString()))
            .setPositiveButton(resources.getString(R.string.accept)){ dialog, which ->
                showVideo()
                dialog.dismiss()
            }.setNegativeButton(resources.getString(R.string.cancel)){ dialog, which ->
                dialog.dismiss()
            }.show()
    }

    private fun showVideo(){
        findNavController().navigate(R.id.action_calendarFragment_to_videoFragment)
    }

}
