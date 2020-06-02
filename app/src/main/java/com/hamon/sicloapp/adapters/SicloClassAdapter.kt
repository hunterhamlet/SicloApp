package com.hamon.sicloapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hamon.sicloapp.databinding.RowEventCalendarBinding
import com.hamon.sicloapp.models.SicloClass
import com.squareup.picasso.Picasso

class SicloClassAdapter(private val listEvents: MutableList<SicloClass> =  mutableListOf(),
                        private val clickClass: (sicloClass: SicloClass) -> Unit ): RecyclerView.Adapter<SicloClassViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SicloClassViewHolder =
        SicloClassViewHolder(RowEventCalendarBinding.inflate(LayoutInflater.from(parent.context), null, false))

    override fun getItemCount(): Int = listEvents.size

    override fun onBindViewHolder(holder: SicloClassViewHolder, position: Int) {
        holder.bind(listEvents[position], clickClass)
    }

    fun addEvents(newListEvents: List<SicloClass>){
        listEvents.clear()
        listEvents.addAll(newListEvents)
        notifyDataSetChanged()
    }

}

class SicloClassViewHolder(private val binding: RowEventCalendarBinding): RecyclerView.ViewHolder(binding.root){
    fun bind(sicloClass: SicloClass, clickClass: (sicloClass: SicloClass) -> Unit ){
        binding.apply {
            classObject = sicloClass
            cardClass.setOnClickListener {
                clickClass.invoke(sicloClass)
            }
        }
    }
}