package com.example.apprende4bg12

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apprende4bg12.databinding.FragmentHomeBinding



class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding get() = _binding!!
    private lateinit var serviceAdapter: ServiceAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        serviceAdapter = ServiceAdapter(
            listOf(

                ServiceModel(
                    "1",
                    R.drawable.programming.toString(),
                    "Desarrollo de software",
                    "Desarrolla tus apps moviles o web y crea tu propio estilo en el mercado",

                ),
                ServiceModel(
                    "2",
                    R.drawable.finance.toString(),
                    "Finanzas",
                    "Integrate al mundo de las finanzas y desarrolla planes de empresariales"
                ),
                ServiceModel(
                    "3",
                    R.drawable.bussines.toString(),
                    "Negocios",
                    "Crea nuevas estrtegias de negociación y ejecuta proyectos",

                ),
                ServiceModel(
                    "4",
                    R.drawable.habblandas.toString(),
                    "Habilidades blandas",
                    "Mejora tus softskills e integrate a la nueva manera de trabajar en equipo"
                ),
                ServiceModel(
                    "5",
                    R.drawable.musica.toString(),
                    "Música",
                    "Crear, canta y compone nuevos sonidos que hagan vibrar el mundo"
                ),
                ServiceModel(
                    "6",
                    R.drawable.diseno.toString(),
                    "Diseño",
                    "Crea lo imposible, el único limite lo impone tu imaginación"
                ),

            )
        )

        serviceAdapter.listener = object : OnServiceClickListener {
            override fun onClick(item: ServiceModel ) {
                    findNavController().navigate(R.id.DevFragment)

            }

        }

        binding.homeFragmentRecycler.apply {
            adapter = serviceAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }

    }

}