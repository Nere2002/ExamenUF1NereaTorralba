package com.skye.examenuf1nereatorralba.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.skye.examenuf1nereatorralba.R
import com.skye.examenuf1nereatorralba.model.Alumne

class AlumneAdapter (private val Alumnes: List<Alumne>, private val onItemClick: (Alumne) -> Unit) :
    RecyclerView.Adapter<AlumneAdapter.AlumneViewHolder>()  {
    // ViewHolder que contiene las vistas para cada elemento
    class AlumneViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val nom: TextView = view.findViewById(R.id.nom)
        val nota: TextView = view.findViewById(R.id.nota)
        val grup: TextView = view.findViewById(R.id.grup)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlumneViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_cardview, parent, false) // Usa tu CardView aquí
        return AlumneViewHolder(view)
    }


    override fun onBindViewHolder(holder: AlumneViewHolder, position: Int) {
        val alumne = Alumnes[position]

        holder.itemView.setOnClickListener {
            onItemClick.invoke(alumne)
        }

        holder.nom.text = alumne.nom
        holder.nota.text = alumne.preu.toString()
        holder.grup.text = alumne.grup
    }

    override fun getItemCount() = Alumnes.size

}