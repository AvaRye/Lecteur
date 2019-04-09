package com.example.lecteur

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var editNumber: EditText
    private lateinit var editPassword: EditText
    private lateinit var login: TextView
    private var number:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initId()
        number = editNumber.editableText.lastIndex
    }

    private fun initId() {
        editNumber = findViewById(R.id.number_login)
        editPassword = findViewById(R.id.password_login)
        login = findViewById(R.id.button_login)
    }

}
