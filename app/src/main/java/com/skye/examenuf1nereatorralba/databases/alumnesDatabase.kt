package com.skye.examenuf1nereatorralba.databases

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.skye.examenuf1nereatorralba.model.Alumne

// Anotación @Database indica que esta clase representa una base de datos Room.
@Database(
    entities = [Alumne::class],// Lista de entidades asociadas a esta base de datos.
    version = 1, // Versión de la base de datos (puedes incrementarla si realizas cambios en la estructura).
    exportSchema = false // Evita exportar el esquema de la base de datos por ahora.
)
abstract class alumnesDatabase : RoomDatabase() {
    abstract  fun alumnesDao(): alumnesDao

    @Volatile
    private  var INSTANCE: alumnesDatabase?=null

    // Método para obtener la instancia de la base de datos o construir una nueva si no existe.
    fun getDatabase(context: Context): alumnesDatabase {
        // if the INSTANCE is not null, then return it,
        // if it is, then create the database
        if (INSTANCE == null) {
            synchronized(this) {
                // Pass the database to the INSTANCE
                INSTANCE = buildDatabase(context)
            }
        }
        // Return database.
        return INSTANCE!!
    }
    // Método privado para construir la base de datos.
    private fun buildDatabase(context: Context): alumnesDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            alumnesDatabase::class.java,
            "alumnes_database" // Nombre de la base de datos.
        )
            .build()
    }
}
