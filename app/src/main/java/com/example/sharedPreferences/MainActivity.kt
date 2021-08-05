package com.example.sharedPreferences

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    lateinit var sharedPreferences : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences = this.getSharedPreferences("com.example.sharedPreferences", Context.MODE_PRIVATE)


        val ageFromSharedPreferences = sharedPreferences.getInt("age", 0)


        if(ageFromSharedPreferences != 0){
            tvInfo.text = "Your Age : $ageFromSharedPreferences"
        }else{
            tvInfo.text = "Your Age :"
        }

        btnSave.setOnClickListener {
            val myAge = etAge.text.toString().toIntOrNull()
            if(myAge != null){
                tvInfo.text = "Your age: $myAge"
                sharedPreferences.edit().putInt("age", myAge).apply()
            }
        }

        btnDelete.setOnClickListener {
            sharedPreferences.edit().remove("age").apply()
            tvInfo.text = "Your age:"
        }


    }

}