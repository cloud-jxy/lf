package com.jocker.jlife.adapters

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.jocker.jlife.utilties.GlideUtil

@BindingAdapter("image_url")
fun setImageFromUrl(view: ImageView, imageUrl: String?) {
    if (!imageUrl.isNullOrEmpty()) {
        GlideUtil.setImage(view.context, imageUrl, view)

/*
        Glide.with(view.context).load(imageUrl)
                .transition(DrawableTransitionOptions.withCrossFade()).into(view)*/
    }
}

object MyBindingAdapters {

}

@BindingAdapter("genres")
fun setGenres(view: TextView, genres: List<String>) {
    if (genres.isNotEmpty()) {
        val joinToString = genres.joinToString("", ",", "")
        view.text = joinToString
    }
}