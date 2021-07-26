package com.mic.servlet

import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet("/response")
class ResponseServlet:HttpServlet() {

    override fun doGet(req: HttpServletRequest?, resp: HttpServletResponse?) {
        doPost(req,resp)
    }

    override fun doPost(req: HttpServletRequest?, resp: HttpServletResponse?) {
        resp?.status=302
        /**
         * 重定向的特点:redirect
        1. 地址栏发生变化
        2. 重定向可以访问其他站点(服务器)的资源
        3. 重定向是两次请求。不能使用request对象来共享数据
         * 转发的特点：forward
        1. 转发地址栏路径不变
        2. 转发只能访问当前服务器下的资源
        3. 转发是一次请求，可以使用request对象来共享数据
         */
        req?.setAttribute("msg","from response")
        val context =this.servletContext
        context.setAttribute("msg2","from response in context")
        //动态获取虚拟目录
        val contextPath = req?.contextPath
        print(contextPath)
        val path = contextPath+"/response2"
        println(path)
        resp?.sendRedirect(path)
    }
}