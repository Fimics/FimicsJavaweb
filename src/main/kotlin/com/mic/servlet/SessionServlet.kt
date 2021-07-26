package com.mic.servlet

import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import javax.servlet.http.HttpSession
import javax.servlet.http.Cookie




@WebServlet("/session")
class SessionServlet:HttpServlet() {

    override fun doGet(req: HttpServletRequest?, resp: HttpServletResponse?) {
        doPost(req,resp)
        val session : HttpSession? = req?.session
        session?.setAttribute("msg","session")
        //期望客户端关闭后，session也能相同
        //期望客户端关闭后，session也能相同
        val c = Cookie("JSESSIONID", session!!.id)
        c.maxAge = 60 * 60
        resp?.addCookie(c)
    }

    override fun doPost(req: HttpServletRequest?, resp: HttpServletResponse?) {
    }
}