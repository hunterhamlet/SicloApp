package com.hamon.sicloapp.bindingAdapters

import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.BindingAdapter
import com.hamon.sicloapp.R
import com.squareup.picasso.Picasso

@BindingAdapter("app:setInstructorImage")
fun AppCompatImageView.setInstructorImage(urlPhoto: String){
    Picasso.get().load(urlPhoto).into(this)
}

@BindingAdapter("app:setInstructorName")
fun AppCompatTextView.setInstructorName(instructorName: String){
    this.setText(this.context.getString(R.string.instructor_name, instructorName))
}

@BindingAdapter("app:setClassHour")
fun AppCompatTextView.setClassHour(classHour: String){
    this.setText(this.context.getString(R.string.init_class, classHour))
}

@BindingAdapter("app:setDurationClass")
fun AppCompatTextView.setDurationClass(durationClass: Int){
    this.setText(this.context.getString(R.string.duration_class, durationClass.toString()))
}

@BindingAdapter("app:setIntensityClass")
fun AppCompatTextView.setIntensityClass(intensityClass: Int){
    this.setText(this.context.getString(R.string.intensity_class, intensityClass.toString()))
}