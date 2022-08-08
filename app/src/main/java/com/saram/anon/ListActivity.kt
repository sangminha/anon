package com.saram.anon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.databinding.DataBindingUtil
import com.saram.anon.databinding.ActivityListBinding
import com.saram.anon.databinding.ActivityRecyclerBinding

import data.UserData
import kotlinx.android.synthetic.main.activity_edit.*

import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : AppCompatActivity() {
    var id = 0
    lateinit var binding: ActivityListBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("테스트5", text12.toString())
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_list)
        setupEvents()
        setValues()

    }


       fun setupEvents() {
//        로그아웃 클릭 이벤트


    }

 fun setValues() {



    }


    }
