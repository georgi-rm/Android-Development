package net.gostartups.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import net.gostartups.myapplication.databinding.ActivitySecondBinding


class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySecondBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.btnBack.setOnClickListener {
            onBackPressed()
        }

        binding.tvCountry.text = intent.getStringExtra("name")
        binding.tvCapital.text = "Capital: " + intent.getStringExtra("capital")
        binding.tvRegion.text = "Region: " + intent.getStringExtra("region")
        binding.tvPopulation.text = "Population: " + intent.getStringExtra("population")
        binding.tvArea.text = "Area: " + intent.getStringExtra("area")

        Glide
            .with(this)
            .load(intent.getStringExtra("flagUrl"))
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(binding.ivFlag)

    }
}