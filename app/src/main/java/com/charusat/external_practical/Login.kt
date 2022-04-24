package com.charusat.external_practical

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnLogin.setOnClickListener {
            var user = edtUser.text.toString()
            var pass = edtPass.text.toString()
            if (TextUtils.isEmpty(user)|| TextUtils.isEmpty(pass)){
                Toast.makeText(applicationContext,"Please enter Username and Password ",Toast.LENGTH_LONG).show()

            }
            else{
                if (user.equals("admin")&& pass.equals("admin")){
                    var pref=getSharedPreferences("mypref", MODE_PRIVATE)
                    var edit = pref.edit()
                    edit.putString("Username",user)
                    edit.commit()
                    intent=Intent(applicationContext,Home::class.java)
                    startActivity(intent)

                }
                else{
                    Toast.makeText(applicationContext,"Please enter Correct Credentials ",Toast.LENGTH_LONG).show()
                }
            }
        }



    }
}