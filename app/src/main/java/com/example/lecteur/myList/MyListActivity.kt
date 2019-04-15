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
import android.widget.Toast
import com.example.lecteur.Translation

import com.example.lecteur.login.MainActivity
import com.example.lecteur.service.MusicService
import com.example.lecteur.service.MusicService.MyBinder
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.lang.Exception
import java.util.ArrayList

class MyListActivity : AppCompatActivity() {
    private lateinit var info:Translation
    private val mainActivity = MainActivity()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_list)
        info = mainActivity.info
        init()
    }

    private fun init() {

    }




}
