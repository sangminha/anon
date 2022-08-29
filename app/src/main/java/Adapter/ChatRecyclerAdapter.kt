package Adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.saram.anon.*
import kotlinx.android.synthetic.main.activity_list.view.*


class ChatRecyclerAdapter(
    val mContext : Context, val mList : List<String>
) : RecyclerView.Adapter<ChatRecyclerAdapter.MyViewHolder>() {

    inner class MyViewHolder (view : View) : RecyclerView.ViewHolder(view) {
        fun bind(item: String) {

            val profileImg = itemView.findViewById<ImageView>(R.id.imgUser_icon)
            val contentTxt = itemView.findViewById<TextView>(R.id.contentTxt)

            val emailTxt = itemView.findViewById<TextView>(R.id.text_context)


            contentTxt.text = emailTxt.text





//            수정 버튼 클릭 이벤트




        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val row = LayoutInflater.from(mContext).inflate(R.layout.activity_friend_location, parent, false)
        return MyViewHolder(row)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(mList[position])
    }

    override fun getItemCount(): Int {
        return mList.size
    }


}