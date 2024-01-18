package com.skye.examenuf1nereatorralba.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.skye.examenuf1nereatorralba.R
import com.skye.examenuf1nereatorralba.adapter.AlumneAdapter
import com.skye.examenuf1nereatorralba.databinding.FragmentGrupBinding
import com.skye.examenuf1nereatorralba.viewmodel.AlumnesViewModel
import com.skye.examenuf1nereatorralba.viewmodel.SharedViewModel
import androidx.lifecycle.Observer

class GrupFragment : Fragment() {
//comit prue
    private lateinit var binding: FragmentGrupBinding
    private lateinit var alumnesViewModel: AlumnesViewModel
    private lateinit var sharedViewModel: SharedViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Infla y vincula el diseño de FragmentCatalegBinding a la variable 'binding'.
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_grup , container, false
        )
        // Inicializa los ViewModels para este fragmento utilizando ViewModelProvider.
        alumnesViewModel = ViewModelProvider(this).get(AlumnesViewModel::class.java)

        sharedViewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)

        viewManager = LinearLayoutManager(context)
        recyclerView = binding.recyclerviewgrup.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
        }


        alumnesViewModel.obtenirAlumnes(requireContext())?.observe(viewLifecycleOwner, Observer { alumnesLlistat ->
            alumnesLlistat?.let {
                // Crea un adaptador MobleAdapter con la lista de mobles y configura un OnClickListener.
                viewAdapter = AlumneAdapter(it) { selectedItem ->
                    // Establece el selectedItem en el SharedViewModel para compartirlo entre fragmentos.
                    sharedViewModel.setSelectedItem(selectedItem)
                    // Navega al Fragmento de Edición cuando se hace clic en un elemento.
                    findNavController().navigate(R.id.alumnesFragment)
                }
                recyclerView.adapter = viewAdapter
            }
        })



        return binding.root

    }


}