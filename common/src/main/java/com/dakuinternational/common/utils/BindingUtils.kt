package com.dakuinternational.common.utils

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import com.dakuinternational.common.R
import com.dakuinternational.common.delegates.OnImageLoaded

//@BindingAdapter("android:scrUri")
//fun srcUri(view: ImageView, uri: String){
//    Glide.with(view.context)
//        .load(uri)
//        .apply( RequestOptions().format(DecodeFormat.PREFER_RGB_565) )
//        .into(view)
//}

@BindingAdapter("android:scrUri", "android:imageLoadedListener")
fun loader(view: ImageView, uri: String, onImageLoaded: OnImageLoaded){
    Glide.with(view.context)
        .load(uri)
        .listener(object: RequestListener<Drawable>{
            override fun onLoadFailed(
                e: GlideException?,
                model: Any?,
                target: Target<Drawable>?,
                isFirstResource: Boolean
            ): Boolean {
                onImageLoaded.onLoad()
                return false
            }

            override fun onResourceReady(
                resource: Drawable?,
                model: Any?,
                target: Target<Drawable>?,
                dataSource: DataSource?,
                isFirstResource: Boolean
            ): Boolean {
                onImageLoaded.onLoad()
                return false
            }
        })
        .apply( RequestOptions().format(DecodeFormat.PREFER_RGB_565) )
        .into(view)
}

