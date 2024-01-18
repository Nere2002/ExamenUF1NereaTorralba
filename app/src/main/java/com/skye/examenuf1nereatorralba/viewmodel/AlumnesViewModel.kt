package com.skye.examenuf1nereatorralba.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.skye.examenuf1nereatorralba.model.Alumne
import com.skye.examenuf1nereatorralba.repositori.Repositori

class AlumnesViewModel : ViewModel() {

    fun obtenirAlumnes(context: Context): LiveData<List<Alumne>>? {

        // Llama al método getAlumnes del Repositori para obtener la lista de mobles como LiveData.
        return Repositori.getAlumnes(context)
    }
}