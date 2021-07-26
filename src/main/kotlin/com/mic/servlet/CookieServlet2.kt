package com.mic.servlet

import javax.servlet.annotation.WebServlet
import javax.servlet.http.Cookie
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet("/cookie2")
class CookieServlet2:HttpServlet() {

    override fun doGet(req: HttpServletRequest?, resp: HttpServletResponse?) {
        doPost(req,resp)
    }

    override fun doPost(req: HttpServletRequest?, resp: HttpServletResponse?) {
         val cs =req?.cookies
        cs?.forEach {
            val name:String? =it.name
            val value:String?=it.value
            println("name-> $name , value->$value")
        }
    }
}