package com.example.routetask.view

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.routetask.R

@BindingAdapter("ImageUrl")
fun loadImg(imageView: ImageView, url: String?) {
    Glide.with(imageView.context).load(url)
        .placeholder(R.drawable.ic_launcher_background)
        .centerCrop().into(imageView)
}