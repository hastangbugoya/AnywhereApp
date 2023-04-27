package com.example.anywhereapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import com.bumptech.glide.Glide
import com.example.anywhereapp.R
import com.example.anywhereapp.databinding.ActivityCharacterDetailsBinding

class CharacterDetailsActivity : AppCompatActivity() {
    val binding: ActivityCharacterDetailsBinding by lazy {
        ActivityCharacterDetailsBinding.inflate(LayoutInflater.from(this))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.titleText.text = intent.getStringExtra("title_text")
        binding.characterDetails.text = intent.getStringExtra("details_text")
        val imageURL = intent.getStringExtra("image_url")
        Log.d("Meow", imageURL ?: "none")
        Glide.with(this)
            .load(imageURL)
            .placeholder(R.drawable.ic_android_black_24dp)
            .into(binding.characterImage)

        binding.characterImgUrl.text = imageURL

    }
}