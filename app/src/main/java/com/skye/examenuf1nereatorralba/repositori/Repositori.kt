package com.skye.examenuf1nereatorralba.repositori

import android.content.Context
import androidx.lifecycle.LiveData
import com.skye.examenuf1nereatorralba.databases.alumnesDatabase
import com.skye.examenuf1nereatorralba.model.Alumne
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Repositori {
    companion object {
        var aalumnesDatabase: alumnesDatabase? = null

        var alumne: LiveData<List<Alumne>>? = null

        fun initializeDB(context: Context): alumnesDatabase {
            return alumnesDatabase.getDatabase(context)
        }

        fun insertAlumne(context: Context, alumne: Alumne) {

            aalumnesDatabase = initializeDB(context)

            // Utiliza un CoroutineScope para ejecutar la operación de inserción en un hilo de fondo.
            CoroutineScope(Dispatchers.IO).launch {
                aalumnesDatabase!!.alumnesDao().addAlumne(alumne)
            }
        }

        fun getAlumnes(context: Context): LiveData<List<Alumne>>? {

            aalumnesDatabase = initializeDB(context)

            // Obtiene la lista de mobles como LiveData desde la base de datos.
            alumne = aalumnesDatabase!!.alumnesDao().getAlumnes()

            return alumne
        }
        fun getMobleById(context: Context, id: Int): LiveData<List<Alumne>>? {

            aalumnesDatabase = initializeDB(context)

            // Obtiene el moble con el ID especificado como LiveData desde la base de datos.
            return aalumnesDatabase!!.alumnesDao().getAlumnesById(id)
        }
    }
}