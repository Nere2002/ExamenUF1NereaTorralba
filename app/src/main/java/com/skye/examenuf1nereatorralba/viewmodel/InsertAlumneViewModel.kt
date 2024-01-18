package com.skye.examenuf1nereatorralba.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.skye.examenuf1nereatorralba.model.Alumne
import com.skye.examenuf1nereatorralba.repositori.Repositori

class InsertAlumneViewModel : ViewModel() {

    fun newAlumne(context: Context, nom: String, nota: Int, grup: String) {

        var alumne = Alumne(nom, nota, grup)

        Repositori.insertAlumne(context, alumne)
    }
}