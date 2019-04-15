package com.example.lecteur.service

import android.annotation.SuppressLint
import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.Binder
import android.os.IBinder
import android.util.Log
import java.lang.Exception


class MusicService : Service() {
    lateinit var binder: MyBinder
    private val TAG = "MyService"


    //constructor
    class MusicService {
        lateinit var mediaPlayer: MediaPlayer

        init {
            try {
                mediaPlayer.setDataSource("") //TODO 获取歌单emm
                mediaPlayer.prepare()
                mediaPlayer.isLooping = true
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        fun playOrPause() {
            if (mediaPlayer.isPlaying) {
                mediaPlayer.pause()
            } else {
                mediaPlayer.start()
            }
        }

        fun stop() {
            mediaPlayer.stop()
            try {
                mediaPlayer.prepare()
                mediaPlayer.seekTo(0)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        fun nextOne(){
            mediaPlayer.stop()
            try {
                mediaPlayer.reset()
//                mediaPlayer.setDataSource()
//                index++
                mediaPlayer.prepare()
                mediaPlayer.seekTo(0)
                mediaPlayer.start()
            } catch (e:Exception) {
                Log.d("hint", "can't jump to the next")
                e.printStackTrace()
            }
        }

        fun preOne(){
            mediaPlayer.stop()
            try {
                mediaPlayer.reset()
//                mediaPlayer.setDataSource()
//                index--
                mediaPlayer.prepare()
                mediaPlayer.seekTo(0)
                mediaPlayer.start()
            } catch (e : Exception) {
                Log.d("hint", "can't jump to pre one")
                e.printStackTrace()
            }
        }
    }

    //binder
    class MyBinder : Binder() {
        fun getService(): MusicService {
            return MusicService()
        }
    }

    override fun onBind(intent: Intent?): IBinder? {
        return binder
    }

    override fun onCreate() {
        super.onCreate()
        Log.w(TAG, "onCreate")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.w(TAG, "onStartCommand")
        Log.w(TAG, "MyService: $this")
        val name = intent?.getStringArrayExtra("name")
        Log.w(TAG, "name: $name")
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.w(TAG, "onDestroy")
    }

}