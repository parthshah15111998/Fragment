package com.example.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.fragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        val firstFragment = firstFragment()
        val secondFragment = secondFragment()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frame_fragment_1,firstFragment,null)
            commit()
        }

        binding.btnFragment1.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.frame_fragment_1,firstFragment)
                addToBackStack(null)
                commit()
            }
        }

        binding.btnFragment2.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.frame_fragment_1,secondFragment,null)
                addToBackStack(null)
                commit()
            }
        }

    }
}