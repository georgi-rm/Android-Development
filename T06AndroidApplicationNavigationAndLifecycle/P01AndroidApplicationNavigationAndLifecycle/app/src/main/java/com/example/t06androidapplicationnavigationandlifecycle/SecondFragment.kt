package com.example.t06androidapplicationnavigationandlifecycle

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.t06androidapplicationnavigationandlifecycle.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    lateinit var binding: FragmentSecondBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(inflater, container, false)

        binding.nextFragment.setOnClickListener {
            val action = SecondFragmentDirections.actionSecondFragmentToThirdFragment()
            Navigation.findNavController(it).navigate(action)
        }

        return binding.root
    }
}