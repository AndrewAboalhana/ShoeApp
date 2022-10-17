package com.example.shoeapp.addlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoeapp.Shoe

class ShoeViewModel:ViewModel(){
    private val _shoeItem= MutableLiveData<MutableList<Shoe>?>(mutableListOf())



    var newAddShoe=Shoe()




    fun addShoe(shoe: Shoe) {
    _shoeItem.value?.add(shoe)
      _shoeItem.value=_shoeItem.value

    }



    fun getShoeLiveData():LiveData<MutableList<Shoe>?>{
        return _shoeItem
    }

    fun resetShow(){
        newAddShoe=Shoe()
    }

}






