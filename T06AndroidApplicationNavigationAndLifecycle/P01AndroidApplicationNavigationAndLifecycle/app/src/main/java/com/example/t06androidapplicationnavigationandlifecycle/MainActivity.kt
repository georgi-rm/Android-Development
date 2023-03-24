package com.example.t06androidapplicationnavigationandlifecycle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.t06androidapplicationnavigationandlifecycle.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.btnToSecondActivity.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("title", "Second Activity")
            startActivity(intent)
        }
    }
}