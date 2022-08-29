package com.saram.anon

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager

import com.saram.anon.databinding.FragmentFriendRequestBinding

class FriendRequestFragment: BasFragment() {

    lateinit var binding : FragmentFriendRequestBinding
   // lateinit var mFriendAdapter : FriendRecyclerViewAdapter
   // val mFriendList = ArrayList<UserData>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_friend_request, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

    }

    override fun setValues() {
//        binding.friendRecyclerView.adapter = mFriendAdapter
        binding.friendRecyclerView.layoutManager = LinearLayoutManager(mContext)

    }
    }