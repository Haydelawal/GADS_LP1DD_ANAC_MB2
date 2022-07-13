package com.example.gads_lp1dd_anac_mb2

import android.graphics.drawable.ColorDrawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.gads_lp1dd_anac_mb2.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var navController: NavController

    ////////// changing the color of each toolbar of each fragment
    private lateinit var listener: NavController.OnDestinationChangedListener

    ////////// changing the color of each toolbar of each fragment
    @RequiresApi(Build.VERSION_CODES.M)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHost) as NavHostFragment
        val navController = navHostFragment.navController

        drawerLayout = binding.drawerLayout
        binding.navigationView.setupWithNavController(navController)


//        ORIGINAL, I MODIFIED IT TO ONE BELOW TO REMOVE THE BACK BUTTON ON THE ACTION BAR
//        WHEN USING BOTTOM NAV VIEW TO NAVIGATE
//        appBarConfiguration = AppBarConfiguration(navController.graph, drawerLayout)


        appBarConfiguration = AppBarConfiguration( setOf(R.id.firstFragment, R.id.secondFragment, R.id.thirdFragment), drawerLayout)

        setupActionBarWithNavController(navController, appBarConfiguration)

        ///// Setting Up the bottom nav
         bottomNavigationView = binding.bottomNav
        bottomNavigationView.setupWithNavController(navController)



        ////////// changing the color of each toolbar of each fragment
        listener =
            NavController.OnDestinationChangedListener { controller, destination, arguments ->

                if (destination.id == R.id.firstFragment) {
                    supportActionBar?.setBackgroundDrawable(ColorDrawable(getColor(R.color.purple_200)))

                } else if (destination.id == R.id.secondFragment) {
                    supportActionBar?.setBackgroundDrawable(ColorDrawable(getColor(R.color.purple_700)))

                }
            }


    }

    ////////// changing the color of each toolbar of each fragment

    override fun onResume() {
        super.onResume()
        val navController = findNavController(R.id.navHost)

        navController.addOnDestinationChangedListener(listener)
    }

    ////////// changing the color of each toolbar of each fragment
    override fun onPause() {
        super.onPause()
        val navController = findNavController(R.id.navHost)

        navController.addOnDestinationChangedListener(listener)

    }


    override fun onSupportNavigateUp(): Boolean {

        val navController = findNavController(R.id.navHost)

        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}