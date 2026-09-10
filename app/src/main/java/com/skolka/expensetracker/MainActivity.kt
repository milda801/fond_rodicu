package com.skolka.expensetracker

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHost = supportFragmentManager.findFragmentById(R.id.navHost) as NavHostFragment
        val navController = navHost.navController
        findViewById<BottomNavigationView>(R.id.bottomNavigation).setupWithNavController(navController)
        findViewById<MaterialToolbar>(R.id.toolbar).apply {
            title = getString(R.string.app_name)
        }
        navController.addOnDestinationChangedListener { _, destination, _ ->
            findViewById<MaterialToolbar>(R.id.toolbar).title = destination.label
        }
    }
}
