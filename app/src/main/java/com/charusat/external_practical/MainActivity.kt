package com.charusat.external_practical

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Handler().postDelayed(Runnable {
            var pref=getSharedPreferences("mypref", MODE_PRIVATE)
            var name=pref.getString("Username","null")
            if (name.equals("null")){
                var intent=Intent(applicationContext,Login::class.java)
                startActivity(intent)
                finish()
            }else{
                var intent=Intent(applicationContext,Home::class.java)
                startActivity(intent)
                finish()
            }

        },3000)
    }
}