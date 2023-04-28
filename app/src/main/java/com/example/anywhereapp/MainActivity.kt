package com.example.anywhereapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import com.example.anywhereapp.databinding.ActivityMainBinding
import com.example.anywhereapp.view.MainRecyclerAdapter
import com.example.anywhereapp.viewmodel.AnywhereViewModel

class MainActivity : AppCompatActivity() {
    private val myViewModel: AnywhereViewModel by viewModels()
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(LayoutInflater.from(this))
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val myAdapter = MainRecyclerAdapter(this)

        binding.mainRecycler.adapter = myAdapter

        myViewModel.dataList.observe(this) {
            myAdapter.setData(it ?: listOf())
        }

        myViewModel.loadData()
    }
}