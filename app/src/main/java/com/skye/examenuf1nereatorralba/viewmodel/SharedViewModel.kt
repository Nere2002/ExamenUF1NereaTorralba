package com.skye.examenuf1nereatorralba.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.skye.examenuf1nereatorralba.model.Alumne

class SharedViewModel : ViewModel() {
    private val _selectedItem = MutableLiveData<Alumne>()

    val selectedItem: LiveData<Alumne> get() = _selectedItem

    //Seleccionar item DB
    fun setSelectedItem(item: Alumne) {
        _selectedItem.value = item
    }
}