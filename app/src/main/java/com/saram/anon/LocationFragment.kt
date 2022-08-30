package com.saram.anon

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import com.saram.anon.databinding.FragmentLocationBinding

class LocationFragment: BasFragment() {

    lateinit var binding : FragmentLocationBinding
    val i2 = 1
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_location, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {
        binding.locationTo.setOnClickListener {


            val myIntent = Intent(mContext, Location_to::class.java)
            startActivity(myIntent)
            Log.d("테스트 232323",i2.toString())


//        내 정보 화면으로 이동 (커스텀 액션바의 icon 클릭이벤트 활용)
        }
    }

    override fun setValues() {


    }

}