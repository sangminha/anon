package com.saram.anon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.saram.anon.databinding.ActivityMainBinding
import com.saram.anon.databinding.ActivitySearchChatBinding

class search_chatActivity : BaseActivity() {
    lateinit var binding: ActivitySearchChatBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_search_chat)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {
//        로그아웃 클릭 이벤트




    }

    override fun setValues() {}
}

