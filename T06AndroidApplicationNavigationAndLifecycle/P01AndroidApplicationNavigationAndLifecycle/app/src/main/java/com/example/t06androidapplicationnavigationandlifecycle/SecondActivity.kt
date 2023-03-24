package com.example.t06androidapplicationnavigationandlifecycle

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import com.example.t06androidapplicationnavigationandlifecycle.databinding.ActivitySecondBinding


class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySecondBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.tvSecondActivityTitle.text = intent.getStringExtra("title")

        binding.btnNextFragment.setOnClickListener {
            val destination =
                Navigation.findNavController(binding.fragmentContainer).currentDestination

            var action = FirstFragmentDirections.actionFirstFragmentToSecondFragment()

            if (destination?.getAction(action.actionId) != null) {
                Navigation.findNavController(binding.fragmentContainer).navigate(action)
            }

            action = SecondFragmentDirections.actionSecondFragmentToThirdFragment()

            if (destination?.getAction(action.actionId) != null) {
                Navigation.findNavController(binding.fragmentContainer).navigate(action)
            }

            action = ThirdFragmentDirections.actionThirdFragmentToFourthFragment()

            if (destination?.getAction(action.actionId) != null) {
                Navigation.findNavController(binding.fragmentContainer).navigate(action)
            }

            action = FourthFragmentDirections.actionFourthFragmentToFirstFragment()

            if (destination?.getAction(action.actionId) != null) {
                Navigation.findNavController(binding.fragmentContainer).navigate(action)
            }
        }
    }
}