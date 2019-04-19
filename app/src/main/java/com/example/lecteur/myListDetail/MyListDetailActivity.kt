package com.example.lecteur.myListDetail

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import cn.edu.twt.retrox.recyclerviewdsl.withItems
import com.example.lecteur.R
import com.example.lecteur.myList.MyListActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.jetbrains.anko.toast
import java.lang.Exception

class MyListDetailActivity : AppCompatActivity() {
    private lateinit var detailInfo: TraDetail
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_list_detail)
        init()
//        getDetail(this, )
    }

    private fun init(){

    }

    private fun getDetail(ui: MyListDetailActivity, id: String) {
        GlobalScope.launch {
            try {
                val retrofit = com.example.lecteur.Retrofit()
                detailInfo = retrofit.request.getDetailAsync(id).await()
                if (detailInfo.code == 200) {
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
