package com.saram.anon


import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_list.view.*


class TopicRecyclerAdapter(
    val mContext : Context, val mList : List<String>
) : RecyclerView.Adapter<TopicRecyclerAdapter.MyViewHolder>() {

    inner class MyViewHolder (view : View) : RecyclerView.ViewHolder(view) {
        fun bind(item: String) {

            val contentTxt = itemView.findViewById<TextView>(R.id.contentTxt)
            val editBtn = itemView.findViewById<Button>(R.id.addReplyBtn12)
            val i =1
            val fragment = (mContext as MainActivity)
                .supportFragmentManager.findFragmentByTag("f1") as RecyclerFragment
            // val rv = itemView.findViewById<RecyclerView>(R.id.rv_profile)
            contentTxt.text = item

            contentTxt.setOnClickListener{
                val myIntent = Intent(mContext, ChatActivity::class.java)
                myIntent.putExtra("content", item)
                    .putExtra("position", bindingAdapterPosition)
                val fragment = (mContext as MainActivity)
                    .supportFragmentManager.findFragmentByTag("f1") as RecyclerFragment
                fragment.startActivityForResult(myIntent, fragment.REQ_FOR_EDIT)
            }

//            수정 버튼 클릭 이벤트
            editBtn.setOnClickListener {
                val myIntent = Intent(mContext, EditActivity::class.java)
                myIntent.putExtra("content", item)
                    .putExtra("position", bindingAdapterPosition)
                val fragment = (mContext as MainActivity)
                    .supportFragmentManager.findFragmentByTag("f1") as RecyclerFragment
                fragment.startActivityForResult(myIntent, fragment.REQ_FOR_EDIT)
//                startActivityForResult를 진행하기 위해서 mContext에 Recycler라는 Activity로 형변환 진행
//                던져주는 2개의 parameter(Intent 변수 - myIntent, requestCode - Recycler Activity에 멤버변수로 생성한 requeset code)
                // (mContext as RecyclerFragment).startActivityForResult(myIntent, mContext.REQ_FOR_EDIT)


            }



        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val row = LayoutInflater.from(mContext).inflate(R.layout.activity_list, parent, false)
        return MyViewHolder(row)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(mList[position])
    }

    override fun getItemCount(): Int {
        return mList.size
    }


}