package com.example.lecteur.myList

import android.content.Context
import android.content.Intent
import android.support.constraint.ConstraintLayout
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import cn.edu.twt.retrox.recyclerviewdsl.Item
import cn.edu.twt.retrox.recyclerviewdsl.ItemController
import com.example.lecteur.R
import com.example.lecteur.myList.TraList
import com.example.lecteur.myListDetail.MyListDetailActivity
import com.squareup.picasso.Picasso
import org.jetbrains.anko.layoutInflater

class ListItem(val mContext: Context, val info: TraList) : Item {
    companion object Controller : ItemController {

        override fun onCreateViewHolder(parent: ViewGroup): ViewHolder {
            val inflater = parent.context.layoutInflater
            val view = inflater.inflate(R.layout.widget_my_list, parent, false)
            val layout = view.findViewById<ConstraintLayout>(R.id.widget_my_list)
            val name = view.findViewById<TextView>(R.id.part_list_name)
            val num = view.findViewById<TextView>(R.id.part_list_num)
            val image = view.findViewById<ImageView>(R.id.part_list_image)
            return ListItem.Controller.ViewHolder(view, name, num, image, layout)
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: Item) {
            holder as ViewHolder
            item as ListItem

            val playList: com.example.lecteur.myList.Playlist = item.info.playlist[0]
            holder.name.text = playList.name
            holder.num.text = playList.playCount.toString()
            Picasso.with(item.mContext).load(playList.coverImgUrl)
                .fit()
                .centerCrop()
                .into(holder.image)
            holder.layout.setOnClickListener {
                val intent = Intent(item.mContext, MyListDetailActivity::class.java)
                    //undone
                    .putExtra("listID", playList.id.toString())
                item.mContext.startActivity(intent)
            }
        }

        class ViewHolder(
            itemView: View,
            val name: TextView,
            val num: TextView,
            val image: ImageView,
            val layout: ConstraintLayout
        ) :
            RecyclerView.ViewHolder(itemView)

    }

    override val controller: ItemController
        get() = ListItem
}




