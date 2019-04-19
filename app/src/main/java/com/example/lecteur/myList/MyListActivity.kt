package com.example.lecteur.myList

import android.app.Service
import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.support.v7.app.AppCompatActivity
import com.example.lecteur.R
import android.os.Bundle
import android.os.IBinder
import android.os.Parcel
import android.os.Parcelable
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.TextView
import android.widget.Toast
import cn.edu.twt.retrox.recyclerviewdsl.withItems
import com.example.lecteur.login.TraLogin
import com.example.lecteur.login.MainActivity
import com.example.lecteur.service.MusicService
import com.example.lecteur.service.MusicService.MyBinder
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import java.lang.Exception

class MyListActivity : AppCompatActivity() {
    private lateinit var loginInfo:TraLogin
    private lateinit var listInfo: TraList
    private lateinit var recyclerView: RecyclerView
    private lateinit var myNum: TextView
    private val mainActivity = MainActivity()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_list)
        loginInfo = mainActivity.info
        init()
        getList(this, loginInfo.profile.userId.toString())
    }

    private fun init() {
        myNum = findViewById(R.id.list_my_num)
        recyclerView = findViewById(R.id.recView_mylist)
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun getList(ui: MyListActivity, uid: String) {
        GlobalScope.launch {
            try {
                val retrofit = com.example.lecteur.Retrofit()
                listInfo = retrofit.request.getListAsync(uid).await()
                if (listInfo.code == 200) {
                    myNum.text = listInfo.playlist[0].playCount.toString()
                    //fun recView
                    recyclerView.withItems {
                        //???
                        //fun adaptDSL
                    }
                } else {
                    toast("？？？")
                }
            } catch (e: Exception) {
                toast("Sorry emmmm")
                e.printStackTrace()
            }

        }
    }




}
