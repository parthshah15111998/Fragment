package com.example.fragment

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.fragment.databinding.ActivityMainBinding
import com.google.android.material.internal.NavigationMenu
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var toggle: ActionBarDrawerToggle
    lateinit var drawerLayout: DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         drawerLayout =findViewById<DrawerLayout>(R.id.drawerLayout)
        val navigationView:NavigationView=findViewById<NavigationView>(R.id.nav_view)

        toggle = ActionBarDrawerToggle(this,drawerLayout,R.string.Open,R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navigationView.setNavigationItemSelectedListener {

            it.isChecked = true

            when(it.itemId){
                R.id.nav_firstHome->replaceFragment(firstFragment(),it.title.toString())
                R.id.nav_secondMessage->replaceFragment(secondFragment(),it.title.toString())
                R.id.nav_thirdSetting->replaceFragment(thirdFragment(),it.title.toString())
                R.id.nav_fourthLogin->replaceFragment(fourthFragment(),it.title.toString())
                R.id.nav_fifthLogout->replaceFragment(fifthFragment(),it.title.toString())
                R.id.nav_sixShare->replaceFragment(sixFragment(),it.title.toString())
                R.id.nav_sevenRate->replaceFragment(sevenFragment(),it.title.toString())
            }
            true
        }

    }


    private fun replaceFragment(fragment: Fragment,title :String){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_fragment_1,fragment)
        fragmentTransaction.commit()
        drawerLayout.close()
        setTitle(title)
    }



    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}