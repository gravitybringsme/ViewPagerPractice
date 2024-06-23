package com.neppplus.viewpagerpractice

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.neppplus.viewpagerpractice.adapters.MainViewPagerAdapter

class MainActivity : AppCompatActivity() {

    lateinit var mViewPagerAdapter : MainViewPagerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        mViewPagerAdapter = MainViewPagerAdapter(supportFragmentManager)

        val mainViewPager = findViewById<androidx.viewpager.widget.ViewPager>(R.id.mainViewPager)
        mainViewPager.adapter = mViewPagerAdapter
        // 페이지가 많아지면 간단하게 부드럽도록 지원하는 기능
        mainViewPager.offscreenPageLimit = 5

    }
}