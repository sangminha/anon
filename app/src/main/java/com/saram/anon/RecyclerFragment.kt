package com.saram.anon

import android.content.Intent
import android.os.Bundle

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.saram.anon.databinding.FragmentRecyclerBinding
import data.UserData
import kotlinx.android.synthetic.main.activity_edit.*


class RecyclerFragment: BasFragment() {

    lateinit var binding: FragmentRecyclerBinding
    lateinit var mFeedRecyclerAdapter: TopicRecyclerAdapter

    // val mFeedList = ArrayList<String>()
    var i = 0

    val mReplyList = ArrayList<String>()

    //    댓글을 쓰기 위한 RequestCode
    val REQ_FOR_REPLY = 1004

    //    댓글 수정 확인을 위한 RequestCode
    val REQ_FOR_EDIT = 1005
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_recycler, container, false)
        Log.d("테스트1223",i.toString())
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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

    override fun setupEvents() {   Log.d("테스트12223",i.toString())
        binding.addReplyBtn.setOnClickListener {


            val myIntent = Intent(mContext, EditActivity::class.java)
            startActivityForResult(myIntent, REQ_FOR_REPLY)

//        내 정보 화면으로 이동 (커스텀 액션바의 icon 클릭이벤트 활용)
        }

    }


    override fun setValues() {
        mFeedRecyclerAdapter = TopicRecyclerAdapter(mContext, mReplyList)
        binding.rvProfile.adapter = mFeedRecyclerAdapter
        binding.rvProfile.layoutManager = LinearLayoutManager(mContext)
       // binding.rvProfile.addOnScrollListener(scrollListener)


    }




    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == AppCompatActivity.RESULT_OK) {
            if (requestCode == REQ_FOR_REPLY) {
                val reply = data?.getStringExtra("string")!!

                mReplyList.add(reply)
                mFeedRecyclerAdapter.notifyItemChanged(REQ_FOR_REPLY)
            }
//            RecyclerView에서 수정버튼 클릭해서 돌아온 경우 해당 리스트 수정 이벤트 처리
            else if (requestCode == REQ_FOR_EDIT) {
                val reply = data?.getStringExtra("string")!!
                val alpa = mReplyList.size
                val alpa1 = alpa.minus(i)
                val position = data?.getIntExtra("position", alpa1)!!

//                우선 position에 있는 댓글의 데이터를 삭제
                mReplyList.removeAt(position)
//                해당 포지션에 수정한 후 받아온 데이터 입력
                mReplyList.add(position, reply)
//                수정된 리스트를 리싸이클러뷰에 반영
                mFeedRecyclerAdapter.notifyDataSetChanged()
            }
        }
    }
}