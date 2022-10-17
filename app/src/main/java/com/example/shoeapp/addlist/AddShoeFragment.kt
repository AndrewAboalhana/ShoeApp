package com.example.shoeapp.addlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.shoeapp.R
import com.example.shoeapp.databinding.AddShoeFragmentBinding
import com.example.shoeapp.addlist.ShoeViewModel

class AddShoeFragment : Fragment() {
    private lateinit var viewModel: ShoeViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?, ): View {

        val binding:AddShoeFragmentBinding=DataBindingUtil.inflate(inflater,
        R.layout.add_shoe_fragment,
        container,
        false)

        viewModel = ViewModelProvider(requireActivity()).get(ShoeViewModel::class.java)
        binding.vm=viewModel
        binding.lifecycleOwner=this


       binding.cancelButtonInAddFragment.setOnClickListener {
           findNavController().navigate(AddShoeFragmentDirections.actionAddShoeFragmentToShoeListFragment())
       }

      binding.add.setOnClickListener {
                    viewModel.newAddShoe.apply {
              viewModel.addShoe(shoe = this)
                        viewModel.resetShow()
              it.findNavController().navigate(AddShoeFragmentDirections.actionAddShoeFragmentToShoeListFragment())
          }
      }

        return binding.root
    }


}