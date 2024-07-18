package com.example.routetask.view

import android.graphics.Paint
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.routetask.R
import java.text.DecimalFormat

@BindingAdapter("ImageUrl")
fun loadImg(imageView: ImageView, url: String?) {
    Glide.with(imageView.context).load(url)
        .placeholder(R.drawable.ic_launcher_background)
        .centerCrop().into(imageView)
}

@BindingAdapter("priceBefore", "discount")
fun setPrice(textView: TextView, priceBefore:String,discount:String){
    val priceBeforeFloat = priceBefore.toFloatOrNull() ?: 0f
    val discountFloat = discount.toFloatOrNull() ?: 0f
    val priceAfter = priceBeforeFloat - (priceBeforeFloat * (discountFloat / 100))

    // Format the prices to two decimal places
    val decimalFormat = DecimalFormat("#.##")
    val formattedNewPrice = decimalFormat.format(priceAfter)

    textView.text = "EGP " + formattedNewPrice

}

@BindingAdapter("strikeThrough")
fun paintFlag(textView: TextView, shouldStrikeThrough: Boolean) {
    if (shouldStrikeThrough) {
        textView.paintFlags = textView.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
    } else {
        textView.paintFlags = textView.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
    }
}