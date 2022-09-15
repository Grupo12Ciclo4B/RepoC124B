package com.example.apprende4bg12

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apprende4bg12.databinding.FragmentCoursesBinding


class CoursesFragment : Fragment() {

    private var _binding: FragmentCoursesBinding? = null
    private val binding: FragmentCoursesBinding get() = _binding!!
    private val args: CoursesFragmentArgs by navArgs()
    private lateinit var coursesAdapter: CoursesAdapter
    private lateinit var coursesList: List<CoursesModel>
    private lateinit var originalList: List<CoursesModel>
    private lateinit var categories: List<String>


    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCoursesBinding.inflate(inflater,container,false)
        return binding.root
    }


    override fun onStart() {
        super.onStart()
        categories = listOf(
            "Todos", "Programacion", "Finanzas", "Negocios", "Habilidades Blandas", "Musica", "Diseño"
        )
        if(args.search){
            binding.coursesFragmentSearch.visibility = View.VISIBLE
            binding.coursesFragmentTitle.text = getString(R.string.courses_fragment_title)
        }else{
            binding.coursesFragmentSearch.visibility = View.GONE

            binding.coursesFragmentTitle.text = args.name
            coursesList = originalList.filter { x -> x.description == args.name }
        }
        binding.coursesFragmentSearch.setAdapter(
            ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, categories))
        binding.coursesFragmentSearch.setOnItemClickListener{ parent, view, position, id ->
            val category = categories [position]
            if(category != "Todos")
                coursesList = originalList.filter { x -> x.description == category }
            else
                coursesList =originalList

            coursesList = originalList.filter { x -> x.description == category}
            coursesAdapter.changeDataSet(coursesList)

        }
        originalList = listOf(
            CoursesModel("1",R.drawable.javascript.toString(),"JavaScript","Programacion",),
            CoursesModel("2",R.drawable.angular.toString(),"Angular","Programacion"),
            CoursesModel("3",R.drawable.nodejs.toString(),"NodeJS","Programacion",                ),
            CoursesModel("4",R.drawable.kotlin.toString(),"Kotlin","Programacion",),
            CoursesModel("5",R.drawable.css.toString(),"CSS","Programacion"),
            CoursesModel("6",R.drawable.html.toString(),"HTML","Programacion"),
            CoursesModel("7",R.drawable.java.toString(),"Java","Programacion"),
            /* Different Section*/
            CoursesModel("8",R.drawable.microeco.toString(),"Finanzas Personales","DHabilidades Blandas",                ),
            CoursesModel("9",R.drawable.deudas.toString(),"Manejo de Deudas","DHabilidades Blandas"),
            CoursesModel("10",R.drawable.creatividad.toString(),"Creatividad Financiera","DHabilidades Blandas",                ),
            CoursesModel("11",R.drawable.trading.toString(),"Trading","DHabilidades Blandas",),
            /* Different Section */
            CoursesModel("12",R.drawable.negocios.toString(),"Modelos de Negocios","DHabilidades Blandas"),
            CoursesModel("13",R.drawable.estrategias.toString(),"Estrategias de Negocios","DHabilidades Blandas"),
            CoursesModel("14",R.drawable.local.toString(),"Como Iniciar un Negocio","DHabilidades Blandas"),
            /* Different Section*/
            CoursesModel("15",R.drawable.musical.toString(),"Producción Musical","DHabilidades Blandas",                ),
            CoursesModel("16",R.drawable.voz.toString(),"Doblaje de Voz","DHabilidades Blandas"),
            CoursesModel("17",R.drawable.locucion.toString(),"Tecnicas de Locución","DHabilidades Blandas",                ),
            CoursesModel("18",R.drawable.dj.toString(),"Curso de DJ","DHabilidades Blandas",),
            /* Different Section*/
            CoursesModel("19",R.drawable.photo.toString(),"Adobe Photoshop","DHabilidades Blandas"),
            CoursesModel("20",R.drawable.illus.toString(),"Adobe Illustrator","DHabilidades Blandas"),
            CoursesModel("21",R.drawable.corel.toString(),"CorelDraw","DHabilidades Blandas"),
            /* Different Section*/
            CoursesModel("22",R.drawable.liderazgo.toString(),"Liderazgo","Habilidades Blandas"),
            CoursesModel("23",R.drawable.inteemocional.toString(),"Adobe Illustrator","Habilidades Blandas"),
            CoursesModel("24",R.drawable.negocia.toString(),"Habilidades de Negociación","Habilidades Blandas"),
        )

        coursesList = listOf(
            CoursesModel("1",R.drawable.javascript.toString(),"JavaScript","Programacion",),
            CoursesModel("2",R.drawable.angular.toString(),"Angular","Programacion"),
            CoursesModel("3",R.drawable.nodejs.toString(),"NodeJS","Programacion",                ),
            CoursesModel("4",R.drawable.kotlin.toString(),"Kotlin","Programacion",),
            CoursesModel("5",R.drawable.css.toString(),"CSS","Programacion"),
            CoursesModel("6",R.drawable.html.toString(),"HTML","Programacion"),
            CoursesModel("7",R.drawable.java.toString(),"Java","Programacion"),
            /* Different Section*/
            CoursesModel("8",R.drawable.microeco.toString(),"Finanzas Personales","DHabilidades Blandas",                ),
            CoursesModel("9",R.drawable.deudas.toString(),"Manejo de Deudas","DHabilidades Blandas"),
            CoursesModel("10",R.drawable.creatividad.toString(),"Creatividad Financiera","DHabilidades Blandas",                ),
            CoursesModel("11",R.drawable.trading.toString(),"Trading","DHabilidades Blandas",),
            /* Different Section */
            CoursesModel("12",R.drawable.negocios.toString(),"Modelos de Negocios","DHabilidades Blandas"),
            CoursesModel("13",R.drawable.estrategias.toString(),"Estrategias de Negocios","DHabilidades Blandas"),
            CoursesModel("14",R.drawable.local.toString(),"Como Iniciar un Negocio","DHabilidades Blandas"),
            /* Different Section*/
            CoursesModel("15",R.drawable.musical.toString(),"Producción Musical","DHabilidades Blandas",                ),
            CoursesModel("16",R.drawable.voz.toString(),"Doblaje de Voz","DHabilidades Blandas"),
            CoursesModel("17",R.drawable.locucion.toString(),"Tecnicas de Locución","DHabilidades Blandas",                ),
            CoursesModel("18",R.drawable.dj.toString(),"Curso de DJ","DHabilidades Blandas",),
            /* Different Section*/
            CoursesModel("19",R.drawable.photo.toString(),"Adobe Photoshop","DHabilidades Blandas"),
            CoursesModel("20",R.drawable.illus.toString(),"Adobe Illustrator","DHabilidades Blandas"),
            CoursesModel("21",R.drawable.corel.toString(),"CorelDraw","DHabilidades Blandas"),
            /* Different Section*/
            CoursesModel("22",R.drawable.liderazgo.toString(),"Liderazgo","Habilidades Blandas"),
            CoursesModel("23",R.drawable.inteemocional.toString(),"Adobe Illustrator","Habilidades Blandas"),
            CoursesModel("24",R.drawable.negocia.toString(),"Habilidades de Negociación","Habilidades Blandas"),
            )
        coursesAdapter.listener = object : OnCourseClickListener {
            override fun onClick(item: CoursesModel) {
                findNavController().navigate(R.id.homeFragment)
            }


        }
        binding.coursesFragmentRecycler.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = coursesAdapter
        }

    }

}
