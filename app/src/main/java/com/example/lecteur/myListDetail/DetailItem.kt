package com.example.lecteur.myListDetail

import android.content.Context
import android.content.Intent
import android.os.Parcel
import android.os.Parcelable
import android.support.constraint.ConstraintLayout
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import cn.edu.twt.retrox.recyclerviewdsl.Item
import cn.edu.twt.retrox.recyclerviewdsl.ItemController
import com.example.lecteur.R
import com.example.lecteur.myList.ListItem
import com.example.lecteur.myList.Playlist
import com.example.lecteur.playing.PlayingActivity
import org.jetbrains.anko.layoutInflater
import java.security.AccessControlContext

class DetailItem(val mContext: Context, val info: com.example.lecteur.myListDetail.Track) : Item {
    companion object Controller : ItemController {
        override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
            val inflater = parent.context.layoutInflater
            val view = inflater.inflate(R.layout.widget_list_detail, parent, false)
            val name = view.findViewById<TextView>(R.id.part_detail_name)
            val layout = view.findViewById<ConstraintLayout>(R.id.widget_list_detail)
            val rank = view.findViewById<TextView>(R.id.part_detail_rank)
            val ar = view.findViewById<TextView>(R.id.part_detail_ar)
            return DetailItem.Controller.ViewHolder(view, rank, name, ar, layout)

        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: Item) {
            holder as DetailItem.Controller.ViewHolder
            item as DetailItem

            val track:com.example.lecteur.myListDetail.Track = item.info
            holder.name.text = track.name
            holder.ar.text = track.ar[0].name
            holder.layout.setOnClickListener {
                val intent = Intent(item.mContext, PlayingActivity::class.java)
                    .putExtra("songID", track.id.toString())
                item.mContext.startActivity(intent)
            }
        }

        class ViewHolder(
            itemView: View,
            val rank: TextView,
            val name: TextView,
            val ar: TextView,
            val layout: ConstraintLayout
        ) :
            RecyclerView.ViewHolder(itemView)


    }

    override val controller: ItemController
        get() = DetailItem
}