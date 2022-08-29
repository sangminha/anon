package com.saram.anon

import Adapter.ChatRecyclerAdapter
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.saram.anon.databinding.ActivityChatBinding
import com.saram.anon.databinding.ActivityFriendLocationBinding
import com.saram.anon.databinding.ActivityLocationToBinding
import kotlinx.android.synthetic.main.activity_list.*


class ChatActivity : BaseActivity() {
    var i = 1
    lateinit var binding: ActivityFriendLocationBinding

    //   lateinit var mTopicData: UserData
    lateinit var mReplyAdapter: ChatRecyclerAdapter
    val mReplyList = ArrayList<String>()

    //    댓글을 쓰기 위한 RequestCode
    val REQ_FOR_REPLY = 1004
    //    댓글 수정 확인을 위한 RequestCode
    val REQ_FOR_EDIT = 1005
    val REQ = 1006
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_friend_location)
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


    }

    override fun setValues() {
        mReplyAdapter = ChatRecyclerAdapter(mContext, mReplyList)
        binding.profile.adapter = mReplyAdapter
        binding.profile.layoutManager = LinearLayoutManager(mContext)


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK) {
            if (requestCode == REQ) {
                val reply = data?.getStringExtra("string")!!

                mReplyList.add(reply)
                mReplyAdapter.notifyItemChanged(REQ)
            }
//            RecyclerView에서 수정버튼 클릭해서 돌아온 경우 해당 리스트 수정 이벤트 처리

        }
    }



}




