package com.saram.anon

import Adapter.MainViewPagerAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.viewpager2.widget.ViewPager2

import com.saram.anon.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.combine

class MainActivity : BaseActivity() {

    lateinit var binding : ActivityMainBinding
    lateinit var mPagerAdapter : MainViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {
        binding.mainViewPager.registerOnPageChangeCallback(
            object : ViewPager2.OnPageChangeCallback(){
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    when (position) {
                        0 -> binding.bottomNavi.selectedItemId = R.id.location
                        1 -> binding.bottomNavi.selectedItemId = R.id.unnameed
                        2 -> binding.bottomNavi.selectedItemId = R.id.home123

                    }
                }
            }
        )

        binding.bottomNavi.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.location -> binding.mainViewPager.currentItem = 0
                R.id.unnameed -> binding.mainViewPager.currentItem = 1
                R.id.home123 -> binding.mainViewPager.currentItem = 2

            }
            return@setOnItemSelectedListener true
        }
    }

    override fun setValues() {
        mPagerAdapter = MainViewPagerAdapter(this)
        binding.mainViewPager.adapter = mPagerAdapter

        binding.mainViewPager.currentItem = 1
        binding.bottomNavi.selectedItemId = R.id.unnameed
    }
}