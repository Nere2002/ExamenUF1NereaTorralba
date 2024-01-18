package com.skye.examenuf1nereatorralba.databases

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.skye.examenuf1nereatorralba.model.Alumne

@Dao
interface alumnesDao {
    // Método para insertar un nuevo moble en la base de datos.
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addAlumne(alumne: Alumne)
    // Método para obtener la lista de Alumnes ordenada por nombre de manera descendente.
    @Query("SELECT * FROM Alumne ORDER BY nom DESC")
    fun getAlumnes(): LiveData<List<Alumne>>
    // Método para obtener un moble específico por su ID.
    @Query("SELECT * FROM Alumne  where id =:id")
    fun getAlumnesById(id: Int): LiveData<List<Alumne>>
}