package com.example.shoeapp.shoelist

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.shoeapp.R
import com.example.shoeapp.Shoe
import com.example.shoeapp.databinding.ShoeListFragmentBinding
import com.example.shoeapp.databinding.ShoecardBinding
import com.example.shoeapp.addlist.ShoeViewModel

class ShoeListFragment : Fragment() {

    private lateinit var viewModel: ShoeViewModel



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {

        val binding:ShoeListFragmentBinding=DataBindingUtil.inflate(inflater,
        R.layout.shoe_list_fragment,
        container,
        false)



        viewModel = ViewModelProvider(requireActivity()).get(ShoeViewModel::class.java)
        binding.shoeViewModel=viewModel
        binding.setLifecycleOwner(this)

       setHasOptionsMenu(true)

        binding.addButton.setOnClickListener{
            findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToAddShoeFragment())
        }



        viewModel.getShoeLiveData().observe(viewLifecycleOwner){
            it?.forEach{ shoe->
                binding.listItemLayout.addView(getViewForShoe(shoe))
            }
        }




        return binding.root

    }



    private fun getViewForShoe(shoe: Shoe): View {
        val shoeBindingView = ShoecardBinding.inflate(LayoutInflater.from(requireContext()),null,false)
        shoeBindingView.shoe=shoe
        shoeBindingView.executePendingBindings()
        return shoeBindingView.root
    }




    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.logout_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(item.itemId==R.id.logout_button){
          findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToLoginFragment())
        }
        return super.onOptionsItemSelected(item)

    }
}






