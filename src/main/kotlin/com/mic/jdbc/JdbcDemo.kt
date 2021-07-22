package com.mic.jdbc

import java.lang.Exception
import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.Statement

//https://blog.csdn.net/u013064109/article/details/78786646

fun main(args: Array<String>) {
//    connection();
    connection2()
}

fun connection() {
//    val conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db3", "root", "root")
    val coon: Connection = DriverManager.getConnection("jdbc:mysql:///javaweb", "root", "steven720")
    val sql: String = "update student3 set age = 20 where age=22"
    val stmt: Statement = coon.createStatement()
    var count:Int = stmt.executeUpdate(sql)
    println(count)
    stmt.close()
    coon.close()
}

fun connection2(){
    var coon:Connection? =null
    var stmt:Statement? =null
    var rs:ResultSet? =null
    try {
        Class.forName("com.mysql.jdbc.Driver")
        coon= DriverManager.getConnection("jdbc:mysql:///javaweb", "root", "steven720")
        stmt= coon.createStatement()
        val sql :String = "select * from student3"
        rs = stmt.executeQuery(sql)

        rs.next()
        val id = rs.getInt(1)
        val name = rs.getString("name")
        println(id)
        println(name)

        /**
         * object.let{
        it.todo()//在函数体内使用it替代object对象去访问其公有的属性和方法
        ...
        }

        //另一种用途 判断object为null的操作
        object?.let{//表示object不为null的条件下，才会去执行let函数体
        it.todo()
        }
        ————————————————
        版权声明：本文为CSDN博主「熊喵先生」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
        原文链接：https://blog.csdn.net/u013064109/article/details/78786646
         */
        rs.let {
            it.next();
            it.close();
        }

        //with函数的适用的场景
        //适用于调用同一个类的多个方法时，可以省去类名重复，直接调用类的方法即可，
       // 经常用于Android中RecyclerView中onBinderViewHolder中，数据model的属性映射到UI上

//        rs.wiwh(a){
//
//        }

        //run函数实际上可以说是let和with两个函数的结合体，
    // run函数只接收一个lambda函数为参数，以闭包形式返回，返回值为最后一行的值或者指定的return的表达式。
        //run函数的适用场景
        //适用于let,with函数任何场景。因为run函数是let,with两个函数结合体，准确来说它弥补了let函数在函数体内必须使用it参数替代对象，在run函数中可以像with函数一样可以省略，直接访问实例的公有属性和方法，另一方面它弥补了with函数传入对象判空问题，在run函数中可以像let函数一样做判空处理
        //————————————————
        //版权声明：本文为CSDN博主「熊喵先生」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
        //原文链接：https://blog.csdn.net/u013064109/article/details/78786646
        rs.run {
//            next()
        }


//        apply
        //从结构上来看apply函数和run函数很像，唯一不同点就是它们各自返回的值不一样，
    // run函数是以闭包形式返回最后一行代码的值，而apply函数的返回的是传入对象的本身。

        //整体作用功能和run函数很像，唯一不同点就是它返回的值是对象本身，而run函数是一个闭包形式返回，返回的是最后一行的值。正是基于这一点差异它的适用场景稍微与run函数有点不一样。apply一般用于一个对象实例初始化的时候，需要对对象中的属性进行赋值。或者动态inflate出一个XML的View的时候需要给View绑定数据也会用到，这种情景非常常见。特别是在我们开发中会有一些数据model向View model转化实例化的过程中需要用到
        //————————————————
        //版权声明：本文为CSDN博主「熊喵先生」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
        //原文链接：https://blog.csdn.net/u013064109/article/details/78786646
//        rs.apply {
//        }

        //also函数的适用场景  适用于let函数的任何场景，also函数和let很像，只是唯一的不同点就是let
    // 函数最后的返回值是最后一行的返回值而also函数的返回值是返回当前的这个对象。一般可用于多个扩展函数链式调用

    }catch (e:Exception){
        e.printStackTrace()
    }finally {
        try {
            rs?.close()
            stmt?.close()
            coon?.close()
        }catch (e:Exception){
            e.printStackTrace()
        }
    }

}

