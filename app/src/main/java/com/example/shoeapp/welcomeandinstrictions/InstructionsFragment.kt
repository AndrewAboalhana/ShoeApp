package com.example.shoeapp.welcomeandinstrictions

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.shoeapp.R
import com.example.shoeapp.databinding.InstructionsFragmentBinding


class InstructionsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        val binding:InstructionsFragmentBinding=DataBindingUtil.inflate(inflater,
        R.layout.instructions_fragment,
        container,
        false)

        binding.makeShoppingButton.setOnClickListener {
            findNavController().navigate(InstructionsFragmentDirections.actionInstructionsFragment2ToShoeListFragment())
        }

        return binding.root
    }


}