package com.charko.retrofitcoroutineexample

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.charko.retrofitcoroutineexample.model.UserInfo

object MainAdapterManager {

    @JvmStatic
    @BindingAdapter("main.items")
    fun setBind(view: RecyclerView, items: List<UserInfo>?) {
        view.adapter?.run {
            if (this is MainUserAdapter) {
                this.users = items ?: listOf()

                this.notifyDataSetChanged()
            }
        }
    }

//    @JvmStatic
//    @BindingAdapter("imageUrl")
//    fun loadImage(imageView: ImageView, url: String) {
//        Glide.with(imageView.context).load(url).into(imageView)
//    }
}