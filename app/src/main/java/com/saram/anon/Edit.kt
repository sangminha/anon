package com.saram.anon


import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.saram.anon.databinding.ActivityEditBinding
import data.UserData

class Edit : BaseActivity() {

    lateinit var binding: ActivityEditBinding
    lateinit var mTopicData: UserData
    val id = 0
    val id2 = 1


    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("테스트-1",id.toString())
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_edit)
        setupEvents()
        setValues()

    }

    override fun setupEvents() {
        binding.Btn123.setOnClickListener {
            val inputContent = binding.text12.text.toString()

            val resultIntent = Intent()
            resultIntent.putExtra("string", inputContent)
            setResult(RESULT_OK, resultIntent)
            finish()
        }

    }

    override fun setValues() {
        Log.d("테스트001",id2.toString())


        Log.d("테스트0012",id2.toString())
        var input = binding.text12.text
        Log.d("테스트3",input.toString())
    }
}