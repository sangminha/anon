package com.saram.anon

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.saram.anon.databinding.ActivityMainBinding
import data.UserData
import kotlinx.android.synthetic.main.fragment_login.*
import org.json.JSONObject
class LoginFragment : Fragment() {
    class SettingFragment : Fragment() {

        val REQ_FOR_EDIT = 1004

        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            return inflater.inflate(R.layout.fragment_login, container, false)
        }

        override fun onActivityCreated(savedInstanceState: Bundle?) {
            super.onActivityCreated(savedInstanceState)
            unnamed.setOnClickListener {

                val myIntent = Intent(requireContext(), RecyclerFragment::class.java)
                startActivity(myIntent)

            }


        }

    }
}

