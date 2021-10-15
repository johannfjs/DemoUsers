package com.johannfjs.demousers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.johannfjs.demousers.databinding.ActivityMainBinding
import com.johannfjs.demousers.dto.User

//TODO https://jsonplaceholder.typicode.com/users
class MainActivity : AppCompatActivity(), UserCallback {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = UsersAdapter(this)
        binding.users.layoutManager = LinearLayoutManager(this)
        binding.users.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
        binding.users.adapter = adapter

        val list = mutableListOf<User>()
        list.add(
            User(
                null,
                null,
                "johannfjs@gmail.com",
                1,
                "Johann",
                "+51990870011",
                "johannfjs",
                "https://johannfjs.com/"
            )
        )
        list.add(
            User(
                null,
                null,
                "johannfjs@gmail.com",
                2,
                "Johann",
                "+51990870011",
                "johannfjs",
                "https://johannfjs.com/"
            )
        )
        adapter.addItems(list)
    }

    override fun onItemClick(user: User) {
        Log.d("users-log", "Username: ${user.username}")
    }
}