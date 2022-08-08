package com.saram.anon

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.saram.anon.databinding.ActivityMainBinding
import data.UserData
import org.json.JSONObject
class MainActivity : BaseActivity() {

    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {
//        로그아웃 클릭 이벤트

        binding.unnamed.setOnClickListener {
            val myIntent = Intent(mContext, Recycler::class.java)
            startActivity(myIntent)
            finish()
        }
    }

        override fun setValues() {}}

