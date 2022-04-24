package com.charusat.external_practical

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_home.*

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        btnInsert.setOnClickListener {
            var name=edtName.text.toString()
            var desig=edtDesig.text.toString()
            var sal=edtSal.text.toString().toInt()
            var employee=Employee(name,desig,sal)
            var db=DBHelper(this)
            var flag=db.insert(employee)

            if(flag)
            {
                Toast.makeText(this,"Record Inserted Successfully",Toast.LENGTH_LONG).show()
            }
            else
            {
                Toast.makeText(this,"Failed",Toast.LENGTH_LONG).show()
            }
        }

        btnViewAll.setOnClickListener {
            var intent=Intent(this,ViewAllActivity::class.java)
            startActivity(intent)
        }


    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.mymenu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var id = item.itemId
        if(id.equals(R.id.logout))
        {
            var sp: SharedPreferences = getSharedPreferences("mypref", MODE_PRIVATE)
            var prefedit = sp.edit()
            prefedit.clear()
            prefedit.commit()
            var intent = Intent(this,Login::class.java)
            startActivity(intent)
            finish()
        }
        return super.onOptionsItemSelected(item)
    }


}