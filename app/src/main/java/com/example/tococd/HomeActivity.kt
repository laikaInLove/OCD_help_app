package com.example.tococd

import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.tococd.databinding.ActivityHomeBinding
import com.example.tococd.presentation.screens.information.InformationFragment
import com.example.tococd.presentation.screens.psychologist.PsychologistsFragment
import com.example.tococd.presentation.screens.types.TypesFragment


class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var navController: NavController
    private var pressedTime: Long = 0

    private val informationFragment = InformationFragment()
    private val typesFragment = TypesFragment()
    private val psychologistsFragment = PsychologistsFragment()
    private var activeFragment: Fragment = informationFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navHostContainer) as NavHostFragment
        navController = navHostFragment.navController

        supportFragmentManager.beginTransaction().apply {
            add(R.id.navHostContainer, informationFragment)
            add(R.id.navHostContainer, typesFragment)//.hide(typesFragment)
            add(R.id.navHostContainer, psychologistsFragment)//.hide(psychologistsFragment)
        }.commit()

        binding.bottomNavigationView.setOnItemSelectedListener { i ->
            /*var fragment: Fragment? = null
            val fragmentByTag = supportFragmentManager.findFragmentByTag("fragment_types_tag")
            fragmentByTag?.let {
                Toast.makeText(this, "creado", Toast.LENGTH_SHORT).show()
            }
            when (i) {
                R.id.information_fragment ->
                    fragment = InformationFragment()

                R.id.ocd_types ->
                    fragment = TypesFragment()

                R.id.psychologist_fragment ->
                    fragment = PsychologistsFragment()
            }

            if (fragment != null) {
                supportFragmentManager.beginTransaction()
                    .addToBackStack(null)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    .replace(
                        R.id.navHostContainer,
                        fragment
                    ).commit()
            }*/
            when (i) {
                R.id.information_fragment -> {
                    supportFragmentManager.beginTransaction().hide(activeFragment).show(informationFragment)
                    activeFragment = informationFragment
                }
                R.id.ocd_types -> {
                    supportFragmentManager.beginTransaction().hide(activeFragment).show(typesFragment)
                    activeFragment = typesFragment
                }

                R.id.psychologist_fragment -> {
                    supportFragmentManager.beginTransaction().hide(activeFragment).show(psychologistsFragment)
                    activeFragment = psychologistsFragment
                }
            }

        }


    }

    override fun onBackPressed() {
        if (pressedTime + 2000 > System.currentTimeMillis()) {
            super.onBackPressed()
            finishAffinity()
        } else {
            Toast.makeText(baseContext, "Press back again to exit", Toast.LENGTH_LONG).show()
        }
        pressedTime = System.currentTimeMillis()
    }



    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.bottom_menu, menu)
        return true
    }

}

