package com.example.androidavanpractica1.ui.gallery

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidavanpractica1.AdaptadorPeliculas
import com.example.androidavanpractica1.DatosPelicula
import com.example.androidavanpractica1.Pelicula
import com.example.androidavanpractica1.PeliculaDetalle
import com.example.androidavanpractica1.databinding.FragmentGalleryBinding

class PeliculasFragmento : Fragment(), AdaptadorPeliculas.OnItemListener {

    private lateinit var  binding: FragmentGalleryBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGalleryBinding.inflate(inflater,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val datos = DatosPelicula(requireContext()).obtenerPeliculas()
        val adaptadorPeliculas = AdaptadorPeliculas(requireContext(),datos,this)
        with(binding){
           val liman = LinearLayoutManager(requireContext())
           amRvPeliculas.addItemDecoration(DividerItemDecoration(requireContext(),liman.orientation))
           amRvPeliculas.layoutManager = liman
            amRvPeliculas.adapter = adaptadorPeliculas
        }
    }

    override fun clickPelicula(lista: Pelicula) {
        Toast.makeText(requireContext(),"Peli: ${lista.idImagen}",Toast.LENGTH_LONG).show()
        println(lista)
        println(lista.idImagen)
        val intent = Intent(activity, PeliculaDetalle::class.java)
        intent.putExtra("idImagen", lista.idImagen)
        startActivity(intent)
    }




}