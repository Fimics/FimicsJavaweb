package com.mic.servlet

import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet("/post")
//@WebServlet("user/post")
//@WebServlet("p1","p2")
//@WebServlet("user/")
//@WebServlet("*.do")
class PostServlet:HttpServlet() {

    private lateinit var message: String


    override fun init() {
        println("init 1")
        message = "post"
    }


    override fun doGet(req: HttpServletRequest?, resp: HttpServletResponse?) {
        println("doGet")
    }

    override fun doPost(req: HttpServletRequest?, resp: HttpServletResponse?) {
        println("doPost")
        val out = resp?.writer
        out?.println("<html><body>")
        out?.println("<h1>$message</h1>")
        out?.println("</body></html>")
    }
}