package com.saram.anon


import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_edit.*
import kotlinx.android.synthetic.main.activity_edit.view.*
import kotlinx.android.synthetic.main.activity_list.view.*


class TopicRecyclerAdapter(
    val mContext : Context, val mList : List<String>
) : RecyclerView.Adapter<TopicRecyclerAdapter.MyViewHolder>() {

    inner class MyViewHolder (view : View) : RecyclerView.ViewHolder(view) {
        fun bind(item: String){
            //val inP = itemView.findViewById<Button(R.id.addReplyBtn12)
            val contentTxt = itemView.findViewById<TextView>(R.id.contentTxt)

            contentTxt.text = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val row = LayoutInflater.from(mContext).inflate(R.layout.activity_list, parent, false)
        return MyViewHolder(row)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(mList[position])

        holder.itemView.addReplyBtn12.setOnClickListener {
        val int = Intent(holder.itemView?.context,Edit::class.java)

            ContextCompat.startActivity(holder.itemView.context,int,null)

        }

    }

    override fun getItemCount(): Int {
        return mList.size
    }


}