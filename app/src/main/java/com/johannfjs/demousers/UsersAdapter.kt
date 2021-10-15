package com.johannfjs.demousers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.johannfjs.demousers.databinding.ItemUserBinding
import com.johannfjs.demousers.dto.User

class UsersAdapter(val callback: UserCallback) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var list = mutableListOf<User>()

    inner class UserViewHolder(private val binding: ItemUserBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            val user = list[position]
            binding.name.text = "Name: ${user.name}"
            binding.username.text = "Username ${user.username}"
            binding.email.text = "Email: ${user.email}"
            binding.phone.text = "Phone: ${user.phone}"
            binding.website.text = "Website: ${user.website}"
            binding.company.text = "Company: ${user.company?.name}"
            callback.onItemClick(user)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is UserViewHolder) {
            holder.bind(position)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun addItems(list: List<User>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }
}

interface UserCallback {
    fun onItemClick(user: User)
}