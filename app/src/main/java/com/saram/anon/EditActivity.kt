package com.saram.anon


import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.saram.anon.databinding.ActivityEditBinding
import data.UserData

class EditActivity : BaseActivity() {

    lateinit var binding: ActivityEditBinding
    lateinit var mTopicData: UserData
    val id = 0
    val id2 = 1

    //    몇번째 리스트에 있던 댓글인지를 받아올 position 값
    var position : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("테스트-1",id.toString())
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_edit)
//        RecyclerView에서 수정을 하기 위해 intent를 사용한 경우 position 값이 intent안에 잇음
//        Int의 경우 intent로 값을 가져올 경우 defaultValue라는 기본 값을 지정해야함.
        position = intent.getIntExtra("position", 0)

        setupEvents()
        setValues()

    }

    override fun setupEvents() {
        binding.Btn123.setOnClickListener {
            val inputContent = binding.text12.text.toString()

            val resultIntent = Intent()
//            기록된 값 혹은 수정된 값을 담아주는 putExtra
            resultIntent.putExtra("string", inputContent)
//            만약 수정일 경우 위에서 intent로 받아온 position을 넣어서 Recycler Activity에서 활용
            resultIntent.putExtra("position", position)
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