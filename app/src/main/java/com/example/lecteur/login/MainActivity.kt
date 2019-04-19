package com.example.lecteur.login

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import com.example.lecteur.R
import com.example.lecteur.myList.MyListActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.jetbrains.anko.*
//import org.jetbrains.anko.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    private lateinit var editNumber: EditText
    private lateinit var editPassword: EditText
    private lateinit var login: TextView
    private lateinit var number: CharSequence
    private lateinit var password: CharSequence
    lateinit var info: TraLogin

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        MainActivityUI().setContentView(this)
        init()
    }

    private fun init() {
        editNumber = findViewById(R.id.number_login)
        editPassword = findViewById(R.id.password_login)
        login = findViewById(R.id.button_login)
        number = editNumber.text
        password = editPassword.text
        login.setOnClickListener { onClick(this, number, password) }
    }

    private fun onClick(ui: MainActivity, number: CharSequence?, password: CharSequence?) {
        //login
        tryLogin(ui, number, password)
    }

    private fun tryLogin(ui: MainActivity, number: CharSequence?, password: CharSequence?) {
        GlobalScope.launch {
            //            ui.doAsync{
//                activityUiThreadWithContext {
            try {
                val retrofit = com.example.lecteur.Retrofit()
                info = retrofit.request.getLoginAsync(number.toString(), password.toString()).await()
                if (info.code == 200) {
                    toast("Welcome")
                    startActivity<MyListActivity>()
                } else {
                    toast("Wrong information.")
                }
            } catch (e: Exception) {
                toast("Sorry emmmm")
                e.printStackTrace()
            }

        }
    }
}

/*    class MainActivityUI : AnkoComponent<MainActivity> {
        lateinit var info: Translation

        override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
            verticalLayout {
                val number = editText {
                    hint = "number"
                }
                val password = editText {
                    hint = "password"
                }

                button("Log in") {
                    onClick {
                        ui.owner.tryLogin(ui, number.toString(), password.toString())
                    }
                }

            }
        }

    }*/


/*        ui.doAsync {
            val retrofit = com.example.lecteur.Retrofit()
            val call = retrofit.request.getCallAsync(number.toString(), password.toString())
            activityUiThreadWithContext {

                call.enqueue(object : Callback<Translation> {
                    override fun onResponse(call: Call<Translation>, response: Response<Translation>) {
                        if (response.body() != null) {
                            translation = response.body()!!
                            toast("Logged in.")
                            startActivity<MyListActivity>()
                        } else {
//                    toast("Wrong input")
                        }
                    }

                    override fun onFailure(call: Call<Translation>, t: Throwable) {
                        toast("Something went wrong")
                        t.printStackTrace()
                    }
                })
            }
        }*/


/*
override fun onResponse(call: Call<Translation>, response: Response<Translation>) {
                        if (response.body() != null) {
                            translation = response.body()!!
                            toast("Logged in.")
                            startActivity<MyListActivity>()
                        } else {
                            toast("Wrong input")
                        }
                    }

                    override fun onFailure(call: Call<Translation>, t: Throwable) {
                        toast("Something went wrong")
                        t.printStackTrace()
                    }
 */





