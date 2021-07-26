package com.mic.servlet

import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet("/session2")
class SessionServlet2:HttpServlet() {

    override fun doGet(req: HttpServletRequest?, resp: HttpServletResponse?) {
        doPost(req,resp)
    }

    override fun doPost(req: HttpServletRequest?, resp: HttpServletResponse?) {
        val s = req?.session
        val msg = s?.getAttribute("msg")
        println(msg)
    }
}