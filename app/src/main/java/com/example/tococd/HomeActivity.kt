package com.example.tococd

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.tococd.databinding.ActivityHomeBinding
import com.example.tococd.utils.extension.hide
import com.example.tococd.utils.extension.show
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navHostContainer) as NavHostFragment
        navController = navHostFragment.navController
        binding.bottomNavigation.setupWithNavController(navController)
        setUpListeners()
    }

    private fun setUpListeners() {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            with(binding) {
                when (destination.label) {
                    "fragment_onboarding" -> bottomNavigation.hide()
                    else -> bottomNavigation.show()
                }
            }
        }
    }
}

