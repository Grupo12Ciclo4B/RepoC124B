package com.example.apprende4bg12

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.apprende4bg12.databinding.ActivityCoursesBinding
import com.example.apprende4bg12.databinding.ActivityDevelopmentBinding

class CoursesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCoursesBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoursesBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        val navController = findNavController(R.id.nav_host_dev_fragment)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.homeFragment,
                R.id.coursesFragment,
                R.id.settingsFragment,
                R.id.logoutFragment
            )
        )
        binding.homeNavigation.setupWithNavController(navController)
        binding.homeToolbar.setupWithNavController(navController,appBarConfiguration)

    }
}