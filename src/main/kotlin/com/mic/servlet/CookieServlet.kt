package com.mic.servlet

import javax.servlet.annotation.WebServlet
import javax.servlet.http.Cookie
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet("/cookie")
class CookieServlet:HttpServlet() {
    override fun doGet(req: HttpServletRequest?, resp: HttpServletResponse?) {
        doPost(req,resp)
    }

    override fun doPost(req: HttpServletRequest?, resp: HttpServletResponse?) {
        val cookie = Cookie("cookie","helloCookie")
        resp?.addCookie(cookie)
        val c1:Cookie = Cookie("name","zhangshan")
        resp?.addCookie(c1)
        val c2:Cookie = Cookie("sex","男")

        resp?.addCookie(c2)
        //1.创建Cookie对象
        //1.创建Cookie对象
        val c3 = Cookie("msg", "setMaxAge")
        //2.设置cookie的存活时间
        //c1.setMaxAge(30);//将cookie持久化到硬盘，30秒后会自动删除cookie文件
        //c1.setMaxAge(-1);
        //c1.setMaxAge(300);
        //2.设置cookie的存活时间
        //c1.setMaxAge(30);//将cookie持久化到硬盘，30秒后会自动删除cookie文件
        //c1.setMaxAge(-1);
        //c1.setMaxAge(300);
        c1.maxAge = 0 //删除Cookie
        //设置path，让当前服务器下部署的所有项目共享Cookie信息
        c1.setPath("/");
        //3.发送Cookie
    }
}