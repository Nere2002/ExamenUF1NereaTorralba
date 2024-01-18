package com.skye.examenuf1nereatorralba.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.skye.examenuf1nereatorralba.R
import com.skye.examenuf1nereatorralba.databinding.FragmentAlumnesBinding
import com.skye.examenuf1nereatorralba.viewmodel.AlumnesViewModel
import com.skye.examenuf1nereatorralba.viewmodel.InsertAlumneViewModel


class AlumnesFragment : Fragment() {
    private lateinit var binding: FragmentAlumnesBinding
    private lateinit var insertAlumneViewModel: InsertAlumneViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_alumnes, container, false
        )
        insertAlumneViewModel = ViewModelProvider(this).get(insertAlumneViewModel::class.java)

        binding.buttonAfegir.setOnClickListener {

            // Obtiene el nombre y el precio del producto desde los campos de entrada.
            val nom = binding.nom.text.toString()
            val nota = binding.nota.text.toString().toInt()
            val grup = binding.grup.text.toString()

            // Llama al método newMoble del ViewModel para insertar un nuevo elemento en el catálogo.
            insertAlumneViewModel.newAlumne(requireContext(), nom, nota, grup)
            // Navega al Fragmento de Catálogo después de la inserción exitosa.
            Navigation.findNavController(it).navigate(R.id.action_alumnesFragment_to_grupFragment)
        }


        return binding.root
    }


}