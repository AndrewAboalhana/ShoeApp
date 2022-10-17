package com.example.shoeapp.welcomeandinstrictions

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.shoeapp.R
import com.example.shoeapp.databinding.WelcomeFragmentBinding


class WelcomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        val binding:WelcomeFragmentBinding=DataBindingUtil.inflate(inflater
            ,R.layout.welcome_fragment
            ,container,
            false)

            binding.welcomeButton.setOnClickListener {
                findNavController().navigate(WelcomeFragmentDirections.actionWelcomeFragmentToInstructionsFragment())
            }

       return binding.root
    }


}