package com.charko.retrofitcoroutineexample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.charko.retrofitcoroutineexample.databinding.MainUserItemBinding
import com.charko.retrofitcoroutineexample.model.UserInfo

class MainUserAdapter: RecyclerView.Adapter<MainUserAdapter.UserViewHolder>() {
    var users: List<UserInfo> = listOf()

    inner class UserViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val binding: MainUserItemBinding = MainUserItemBinding.bind(itemView)

        fun bind(item: UserInfo) {
            binding.setVariable(BR.user, item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder = UserViewHolder(
//        MainUserItemBinding.inflate(LayoutInflater.from(parent.context), parent, false).root
        LayoutInflater.from(parent.context).inflate(
            R.layout.main_user_item,
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) = holder.bind(users[position])

    override fun getItemCount(): Int = users.size
}