package com.skye.examenuf1nereatorralba.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// Anotación @Entity indica que esta clase representa una entidad de la base de datos.
@Entity(tableName = "Alumne")
data class Alumne(
    // Columna 'nom' que almacena el nombre del moble.
    @ColumnInfo(name = "nom")
    var nom: String,
    // Columna 'preu' que almacena el precio del moble.
    @ColumnInfo(name = "nota")
    var preu: Int,
    @ColumnInfo(name = "grup")
    var grup: String,
){
    // Clave primaria auto-generada para identificar de manera única cada moble.
    @PrimaryKey(autoGenerate = true)
    var Id: Int? = null
}
