package com.hamon.sicloapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hamon.sicloapp.databinding.RowCalendarDayWeekBinding

class CalendarDaysAdapter(
    private val listDays: MutableList<String> = mutableListOf(),
    private val clickDay: (dayKey: String) -> Unit
) : RecyclerView.Adapter<CalendarDayViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalendarDayViewHolder =
        CalendarDayViewHolder(
            RowCalendarDayWeekBinding.inflate(LayoutInflater.from(parent.context))
        )

    override fun getItemCount(): Int = listDays.size

    override fun onBindViewHolder(holder: CalendarDayViewHolder, position: Int) {
        holder.bind(listDays[position], clickDay)
    }

    fun addDays(newListOfDays: MutableList<String>) {
        listDays.clear()
        listDays.addAll(newListOfDays)
        notifyDataSetChanged()
    }
}

class CalendarDayViewHolder(private val binding: RowCalendarDayWeekBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(day: String, clickDay: (dayKey: String) -> Unit) {
        val daySplit = day.split(" ")
        binding.apply {
            textViewDayTitle.text = daySplit[0]
            textViewDayNumber.text = daySplit[1]
            cardDayCalendar.setOnClickListener {
                clickDay.invoke(day)
            }
            executePendingBindings()
        }
    }
}