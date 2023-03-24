package com.example.t06androidapplicationnavigationandlifecycle

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.t06androidapplicationnavigationandlifecycle.databinding.FragmentFourthBinding

class FourthFragment : Fragment() {

    lateinit var binding: FragmentFourthBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFourthBinding.inflate(inflater, container, false)

        binding.nextFragment.setOnClickListener {
            val action = FourthFragmentDirections.actionFourthFragmentToFirstFragment()
            Navigation.findNavController(it).navigate(action)
        }

        return binding.root
    }
}