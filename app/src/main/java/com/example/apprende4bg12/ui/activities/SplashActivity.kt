package com.example.apprende4bg12.ui.activities

import android.animation.Animator
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.apprende4bg12.AppDatabase
import com.example.apprende4bg12.data.datasources.MemoryDataSource
import com.example.apprende4bg12.databinding.ActivitySplashBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import org.koin.android.ext.android.inject

class SplashActivity : AppCompatActivity() {
    private val db: AppDatabase by inject<AppDatabase>()
    private val memoryDataSource: MemoryDataSource by inject()
    private val scope = CoroutineScope(newSingleThreadContext("splash"))

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }

    override fun onStart() {
        super.onStart()
        scope.launch {
            if (db.coursesDao().count() == 0) {
                db.coursesDao().insertAll(memoryDataSource.getCourses(null))
            }
            if (db.serviceDao().count() == 0) {
                db.serviceDao().insertAll(memoryDataSource.getServices())
            }
        }
        binding.splashAnimation.playAnimation()

        binding.splashAnimation.addAnimatorListener(object: Animator.AnimatorListener{
            override fun onAnimationStart(animation: Animator?) {

            }

            override fun onAnimationEnd(animation: Animator?) {
                val intent = Intent(applicationContext, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }

            override fun onAnimationCancel(animation: Animator?) {

            }

            override fun onAnimationRepeat(animation: Animator?) {

            }


        })

        binding.splash2Animation.playAnimation()
        binding.splash2Animation.addAnimatorListener(object: Animator.AnimatorListener{
            override fun onAnimationStart(animation: Animator?) {

            }

            override fun onAnimationEnd(animation: Animator?) {
                Log.d("golas","finalizado animacion 2")

            }

            override fun onAnimationCancel(animation: Animator?) {

            }

            override fun onAnimationRepeat(animation: Animator?) {

            }

        } )
    }
}