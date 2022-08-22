package com.saram.anon


import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_list.view.*


class TopicRecyclerAdapter(
    val mContext : Context, val mList : List<String>
) : RecyclerView.Adapter<TopicRecyclerAdapter.MyViewHolder>() {

    inner class MyViewHolder (view : View) : RecyclerView.ViewHolder(view) {
        fun bind(item: String){
            val contentTxt = itemView.findViewById<TextView>(R.id.contentTxt)
            val editBtn = itemView.findViewById<Button>(R.id.addReplyBtn12)

            contentTxt.text = item

//            수정 버튼 클릭 이벤트
            editBtn.setOnClickListener {
                val myIntent = Intent(mContext, Edit::class.java)
                myIntent.putExtra("content", mList[position])
                    .putExtra("position", position)
//                startActivityForResult를 진행하기 위해서 mContext에 Recycler라는 Activity로 형변환 진행
//                던져주는 2개의 parameter(Intent 변수 - myIntent, requestCode - Recycler Activity에 멤버변수로 생성한 requeset code)
                (mContext as Recycler).startActivityForResult(myIntent, mContext.REQ_FOR_EDIT)
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