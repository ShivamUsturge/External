package com.charusat.external_practical

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_view_all.*
import kotlinx.android.synthetic.main.custom_dialog_layout.*

class ViewAllActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_all)

        updateRecyclerView()

    }

    public fun update(position: Int)
    {
        var db = DBHelper(this)
        var arr = db.retriveAll()
        var employee = arr.get(position)
        var id = employee.id
        var name = employee.em_name
        var desig = employee.em_desig
        var sal = employee.em_sal
        var dialog = Dialog(this)
        dialog.setContentView(R.layout.custom_dialog_layout)
        dialog.tvID.setText(id.toString())
        dialog.edtDialogName.setText(name)
        dialog.edtDialogDesig.setText(desig)
        dialog.edtDialogSal.setText(sal.toString())
        dialog.btnDialogUpdate.setOnClickListener {
            var id = dialog.tvID.text.toString().toInt()
            var name = dialog.edtDialogName.text.toString()
            var desig = dialog.edtDialogDesig.text.toString()
            var sal = dialog.edtDialogSal.text.toString().toInt()
            var employee=Employee(id,name,desig,sal)
            var flag = db.update(employee)
            if (flag){
                Toast.makeText(this,"Record Updated!!",Toast.LENGTH_LONG).show()
                dialog.dismiss()
                updateRecyclerView()
            }
        }
        dialog.show()
    }

    public  fun delete(position: Int)
    {
        var db=DBHelper(this)
        var arr = db.retriveAll()
        var employee = arr.get(position)
        var id = employee.id
        var flag = db.delete(id)
        if(flag)

            Toast.makeText(this,"Record Deleted!!", Toast.LENGTH_LONG).show()
        updateRecyclerView()

    }
    private fun updateRecyclerView(){
        var db=DBHelper(this)
        var arr = db.retriveAll()
        var employeeAdapter = EmployeeAdapter(this,arr)
        myrecycle.adapter=employeeAdapter
    }
}