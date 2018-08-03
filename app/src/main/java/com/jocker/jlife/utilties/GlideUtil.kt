package com.jocker.jlife.utilties

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.GenericTransitionOptions
import com.bumptech.glide.Glide
import com.bumptech.glide.TransitionOptions
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.jocker.jlife.R

object GlideUtil {

    fun setImage(context: Context, url: String?, imageView: ImageView) {
        if (!url.isNullOrEmpty()) {
            val requestOptions = RequestOptions().error(R.mipmap.ic_pic_error)
            Glide.with(context).setDefaultRequestOptions(requestOptions)
                    .load(url).into(imageView)
        }
    }
}