package com.example.t05androidvisuals

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.t05androidvisuals.databinding.ActivityMainBinding
import java.util.*


class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    private var clickCounter: Int = 0

    private val imagesList: Array<Int> = arrayOf(
        R.drawable.magic_book,
        R.drawable.yellow_book,
        R.drawable.stag,
        R.drawable.beetle,
        R.drawable.bull,
        R.drawable.elephant_01,
        R.drawable.frog,
        R.drawable.gold_fish,
        R.drawable.horse,
        R.drawable.lizard,
        R.drawable.pig,
        R.drawable.rabbit,
        R.drawable.elephant_02,
        R.drawable.butterflies,
        R.drawable.bees,
        R.drawable.seal,
        R.drawable.ant,
        R.drawable.camel,
        R.drawable.panda,
        R.drawable.deer,
        R.drawable.lamb
     )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.clickCounterText = clickCounter.toString()
        setContentView(binding.root)

        binding.buttonClickMe.setOnClickListener {
            clickCounter++
            binding.clickCounterText = clickCounter.toString()

            val randomImageId = imagesList[Random().nextInt(imagesList.size)]
            binding.randomImage.setImageResource(randomImageId)

            val fulPath = resources.getString(randomImageId)
            binding.nameOfImage = resources.getResourceEntryName(randomImageId) + fulPath.substring(fulPath.lastIndexOf('.'))
        }
    }
}