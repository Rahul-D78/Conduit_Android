package com.sih.conduitclone

import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.ViewModelProvider
import com.sih.conduitclone.databinding.ActivityMainBinding
import com.sih.conduitclone.ui.auth.AuthViewModel
import io.realworld.api.models.entities.User

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var authViewModel: AuthViewModel
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        authViewModel = ViewModelProvider(this).get(AuthViewModel::class.java)
        binding = ActivityMainBinding.inflate(layoutInflater)

//        setContentView(R.layout.activity_main)
        setContentView(binding.root)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(setOf(
            R.id.nav_feed,
            R.id.nav_auth
        ), drawerLayout)
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        authViewModel.user.observe({lifecycle}) {
            updateMenu(it)
            navController.navigateUp()
            Toast.makeText(this, "Logged In as ${it.username}}", Toast.LENGTH_SHORT).show()
        }
    }

    private fun updateMenu(user: User?) {
        when (user) {
            is User -> {
                binding.navView.menu.clear()
                binding.navView.inflateMenu(R.menu.menu_main_user)
            }
            else -> {

            }
        }

    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}