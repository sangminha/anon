package com.saram.anon

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

abstract class BasFragment : Fragment() {

    lateinit var mContext: Context


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mContext = requireContext()

    }

    abstract fun setupEvents()
    abstract fun setValues()
}

