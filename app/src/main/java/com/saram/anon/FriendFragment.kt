package com.saram.anon

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import com.saram.anon.databinding.FragmentFriendBinding


class FriendFragment: BasFragment() {

    lateinit var binding : FragmentFriendBinding
  //  lateinit var mFriendAdapter : FriendRecyclerViewAdapter
 //   val mFriendsList = ArrayList<UserData>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_friend, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {
        binding.addFriendBtn.setOnClickListener {
     //       val myIntent = Intent(mContext, SearchUserActivity::class.java)
        //    startActivity(myIntent)
        }
    }

    override fun setValues() {
       // mFriendAdapter = FriendRecyclerViewAdapter(mContext, mFriendsList, "my")
      //  binding.myFriendRecyclerView.adapter = mFriendAdapter
       // binding.myFriendRecyclerView.layoutManager = LinearLayoutManager(mContext)

       // getFriendDataFromServer()
    }
}