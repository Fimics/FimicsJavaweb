package com.mic.jdbc

import java.lang.Exception
import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.Statement
import java.util.*
import kotlin.collections.ArrayList

fun main(args:Array<String>){

    val jdbc :JdbcDemo1 = JdbcDemo1()
    val list = jdbc.findAll();
    list.forEach {
        println(it)
    }

}

class JdbcDemo1 {

    fun findAll():List<Emp>{
        var conn: Connection? = null
        var stmt: Statement?= null
        var rs: ResultSet?=null
        var list:List<Emp>? =null

        conn= DriverManager.getConnection("jdbc:mysql:///javaweb", "root", "steven720")
        stmt= conn.createStatement()
        val sql :String = "select * from emp"
        rs = stmt.executeQuery(sql)

        var emp :Emp?=null
        list = ArrayList<Emp>()
        while (rs.next()){
            var id:Int = rs.getInt(1);
            var ename:String = rs.getString("ename");
            var job_id:Int = rs.getInt("job_id")
            var mgr:Int = rs.getInt("mgr")
            var joindate:Date = rs.getDate("joindate")
            var salary:Double = rs.getDouble("salary")
            var bonus :Double= rs.getDouble("bonus")
            var dept_id = rs.getInt("dept_id")
            emp = Emp(id,ename,job_id,mgr,joindate,salary,bonus,dept_id)
            list.add(emp)
        }

        try {
            Class.forName("com.mysql.jdbc.Driver")
        }catch (e:Exception){
            e.printStackTrace()
        }
        return list
    }
}