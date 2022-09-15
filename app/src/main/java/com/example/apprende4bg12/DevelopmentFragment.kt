package com.example.apprende4bg12

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apprende4bg12.databinding.FragmentDevelopmentBinding
import com.example.apprende4bg12.databinding.FragmentHomeBinding



class DevelopmentFragment : Fragment() {
    private var _binding: FragmentDevelopmentBinding? = null
    private val binding: FragmentDevelopmentBinding get() = _binding!!
    private lateinit var serviceAdapter: ServiceAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDevelopmentBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        serviceAdapter = ServiceAdapter(
            listOf(

                ServiceModel(
                    "1",
                    R.drawable.javascript.toString(),
                    "JavaScript",
                    "",

                ),
                ServiceModel(
                    "2",
                    R.drawable.angular.toString(),
                    "Angular",
                    ""
                ),
                ServiceModel(
                    "3",
                    R.drawable.nodejs.toString(),
                    "NodeJS",
                    "",

                ),
                ServiceModel(
                    "4",
                    R.drawable.kotlin.toString(),
                    "Kotlin",
                    "",
                ),
                ServiceModel(
                    "5",
                    R.drawable.css.toString(),
                    "CSS",
                    ""
                ),
                ServiceModel(
                    "6",
                    R.drawable.html.toString(),
                    "HTML",
                    ""
                ),
                ServiceModel(
                    "7",
                    R.drawable.java.toString(),
                    "Java",
                    ""
                ),

            )
        )

        serviceAdapter.listener = object : OnServiceClickListener {
            override fun onClick(item: ServiceModel) {
                Log.d("item seleccionado: ", item.title)
            }

        }

        /*binding.devFragmentRecycler.apply {
            adapter = serviceAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }*/

    }

}