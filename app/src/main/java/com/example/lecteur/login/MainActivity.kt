package com.example.lecteur.login

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.lecteur.GetRequestInterface
import com.example.lecteur.R
import com.example.lecteur.Translation
import com.example.lecteur.myList.MyListActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk27.coroutines.onClick
//import org.jetbrains.anko.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    private lateinit var editNumber: EditText
    private lateinit var editPassword: EditText
    private lateinit var login: TextView
    private var number: CharSequence? = null
    private var password: CharSequence? = null
    private lateinit var translation: Translation
    lateinit var info: Translation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        MainActivityUI().setContentView(this)
//        init()
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
            try {
                val retrofit = com.example.lecteur.Retrofit()
                info = retrofit.request.getCallAsync(number.toString(), password.toString()).await()
                if (info.code == 200) {
                    Toast.makeText(ui, "Welcome", Toast.LENGTH_LONG).show()
                    val intent = Intent()
                        .setClass(ui, MyListActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(ui, "Wrong information.", Toast.LENGTH_LONG).show()
                }
            } catch (e: Exception) {
                Toast.makeText(ui, "Sorry emmmm", Toast.LENGTH_LONG).show()
                e.printStackTrace()
            }
        }
    }

    class MainActivityUI : AnkoComponent<MainActivity> {
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
                        try {
                            val retrofit = com.example.lecteur.Retrofit()
                            info = retrofit.request.getCallAsync(number.toString(), password.toString()).await()
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
        }

    }
}


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





