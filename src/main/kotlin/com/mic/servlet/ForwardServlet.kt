package com.mic.servlet

import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet("/forward")
class ForwardServlet:HttpServlet() {

    override fun doGet(req: HttpServletRequest?, resp: HttpServletResponse?) {
        resp?.contentType = "text/html"

        val msg = req?.getAttribute("msg")
        // Hello
        val content ="forward"
        val out = resp?.writer
        out?.println("<html><body>")
        out?.println("<h1>$content ${msg}</h1>")
        out?.println("</body></html>")
    }

    override fun doPost(req: HttpServletRequest, resp: HttpServletResponse) {
    }
}