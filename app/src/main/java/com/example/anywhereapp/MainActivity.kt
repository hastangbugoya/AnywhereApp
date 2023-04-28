package com.example.anywhereapp

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.inputmethod.EditorInfo
import androidx.activity.viewModels
import com.example.anywhereapp.databinding.ActivityMainBinding
import com.example.anywhereapp.view.MainRecyclerAdapter
import com.example.anywhereapp.viewmodel.AnywhereViewModel

class MainActivity : AppCompatActivity() {
    private val myViewModel: AnywhereViewModel by viewModels()
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(LayoutInflater.from(this))
    }
    val myAdapter: MainRecyclerAdapter by lazy {
        MainRecyclerAdapter(this)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.mainRecycler.adapter = myAdapter

        myViewModel.dataList.observe(this) {
            myAdapter.setData(it ?: listOf())
        }

        myViewModel.loadData()

        binding.filterText.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE || actionId == EditorInfo.IME_ACTION_NEXT) {
                if (!binding.filterText.text.trim().isNullOrEmpty())
                    myAdapter.setData(myViewModel.filterList(binding.filterText.text.trim().toString()))
                else
                    myViewModel.dataList.value?.let { myAdapter.setData(it) }  ?: myAdapter.setData(
                        listOf()
                    )
                true
            } else {
                false
            }
        }

    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        binding.mainRecycler.adapter = myAdapter
    }
}