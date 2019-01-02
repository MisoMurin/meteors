package com.murin.meteors

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import com.murin.meteors.databinding.ActivityMeteorsBinding

class MeteorsActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMeteorsBinding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_meteors
        )

        setSupportActionBar(binding.toolbar)

        navController = Navigation.findNavController(this, R.id.meteors_nav_fragment)
        appBarConfiguration = AppBarConfiguration(navController.graph, null)


    }
}
