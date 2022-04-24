package com.charusat.external_practical

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.core.content.contentValuesOf

class DBHelper(context:Context):SQLiteOpenHelper(context,DB_NAME,null,DB_VERSION) {

    companion object {
        private var DB_NAME = "Employee"
        private var TB_NAME = "EmployeeDetails"
        private var DB_VERSION = 7
        private var EM_NAME = "em_name"
        private var EM_ID = "id"
        private var EM_DESIG = "em_desig"
        private var EM_SAL = "em_sal"

    }

    override fun onCreate(p0: SQLiteDatabase?) {
        var query = "CREATE TABLE $TB_NAME ($EM_ID INTEGER PRIMARY KEY AUTOINCREMENT, $EM_NAME TEXT, $EM_DESIG TEXT, $EM_SAL INTEGER)"
        p0?.execSQL(query)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
//    var query= "DROP TABLE $TB_NAME "
//        p0?.execSQL(query)
        //onCreate(p0)

    }
    fun insert(employee: Employee): Boolean {
        var db = writableDatabase
        var cv = ContentValues()
        cv.put(EM_NAME, employee.em_name)
        cv.put(EM_DESIG, employee.em_desig)
        cv.put(EM_SAL, employee.em_sal)

        var flag = db.insert(TB_NAME, null, cv)
        if (flag>0)
        {
            return true
        }
        else {
            return false
        }
    }

    fun retriveAll():ArrayList<Employee>
    {
        var db= readableDatabase
        var cursor = db.query(TB_NAME,null,null,null,null,null,null)
        var arr:ArrayList<Employee> = ArrayList()
        while(cursor.moveToNext())
        {
            var id=cursor.getInt(0)
            var name=cursor.getString(1)
            var desig=cursor.getString(2)
            var sal=cursor.getInt(3)
            var employee=Employee(id,name,desig,sal)
            arr.add(employee)

        }
        return arr
    }

    fun update(employee: Employee):Boolean
    {
        var db=writableDatabase
        var cv=ContentValues()
        cv.put(EM_NAME,employee.em_name)
        cv.put(EM_DESIG,employee.em_desig)
        cv.put(EM_SAL,employee.em_sal)
        var flag=db.update(TB_NAME,cv,"$EM_ID=${employee.id}",null)
        if (flag>0)
            return true
        else
            return false

    }

    fun delete(id:Int):Boolean
    {
        var db=writableDatabase
        var flag=db.delete(TB_NAME,"$EM_ID=$id",null)
        if(flag>0){
            return true
        }
        else{
            return false
        }
    }


}