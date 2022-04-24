package com.charusat.external_practical

data class Employee(var em_name: String, var em_desig:String, var em_sal:Int) {

        var id = 0
        constructor(id:Int,em_name:String,em_desig:String,em_sal:Int):this(em_name,em_desig,em_sal){

            this.id = id
        }
}