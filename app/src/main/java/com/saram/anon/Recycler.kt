
package com.saram.anon


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.saram.anon.databinding.ActivityRecyclerBinding
import kotlinx.android.synthetic.main.activity_edit.*

import org.json.JSONObject
import java.util.Collections.list

class Recycler : BaseActivity() {
    var i = 0
    lateinit var binding: ActivityRecyclerBinding

    //   lateinit var mTopicData: UserData
    lateinit var mReplyAdapter: TopicRecyclerAdapter
    val mReplyList = ArrayList<String>()

    //    댓글을 쓰기 위한 RequestCode
    val REQ_FOR_REPLY = 1004
    //    댓글 수정 확인을 위한 RequestCode
    val REQ_FOR_EDIT = 1005

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_recycler)
        setupEvents()
        setValues()
    }

//    override fun onResume() {
//        super.onResume()
//        val reply: String? = intent.getStringExtra("string")
//        if (reply != null) {
//            mReplyList.add(reply)
//            mReplyAdapter.notifyDataSetChanged()
//        }
//    }

    override fun setupEvents() {
        binding.addReplyBtn.setOnClickListener {
            Log.d("테스트-2", i.toString())
            val myIntent = Intent(mContext, Edit::class.java)
            startActivityForResult(myIntent, REQ_FOR_REPLY)


//        내 정보 화면으로 이동 (커스텀 액션바의 icon 클릭이벤트 활용)
        }

    }

    override fun setValues() {
        mReplyAdapter = TopicRecyclerAdapter(mContext, mReplyList)
        binding.rvProfile.adapter = mReplyAdapter
        binding.rvProfile.layoutManager = LinearLayoutManager(mContext)


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK) {
            if (requestCode == REQ_FOR_REPLY) {
                val reply = data?.getStringExtra("string")!!

                mReplyList.add(reply)
                mReplyAdapter.notifyItemChanged(REQ_FOR_REPLY)
            }
//            RecyclerView에서 수정버튼 클릭해서 돌아온 경우 해당 리스트 수정 이벤트 처리
            else if (requestCode == REQ_FOR_EDIT) {
                val reply = data?.getStringExtra("string")!!
                val position = data?.getIntExtra("position", 0)!!

//                우선 position에 있는 댓글의 데이터를 삭제
                mReplyList.removeAt(position)
//                해당 포지션에 수정한 후 받아온 데이터 입력
                mReplyList.add(position, reply)
//                수정된 리스트를 리싸이클러뷰에 반영
                mReplyAdapter.notifyDataSetChanged()
            }
        }
    }



}
