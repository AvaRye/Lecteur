package com.example.lecteur.playing

import android.content.ComponentName
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import com.example.lecteur.R
import com.example.lecteur.service.MusicService

class PlayingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_playing)
        bindServiceConnection()

    }


    interface ServiceConnection:android.content.ServiceConnection{
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            var musicService: MusicService? = null

        }

        override fun onServiceDisconnected(name: ComponentName?) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
    }
    lateinit var serviceConnection: ServiceConnection
    val BIND = 1

    private fun bindServiceConnection() {
        var intent = Intent(this, MusicService().javaClass)
        startActivity(intent)
        bindService(intent, serviceConnection, this.BIND)
    }
}
