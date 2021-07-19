package com.mic.servlet

import java.util.*
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse




@WebServlet("/req")
class RequestServlet:HttpServlet() {

    override fun doGet(req: HttpServletRequest?, resp: HttpServletResponse?) {
        println("doGet")
        //1. 获取请求方式 ：GET
        /*
            1. 获取请求方式 ：GET
                * String getMethod()
            2. (*)获取虚拟目录：/day14
                * String getContextPath()
            3. 获取Servlet路径: /requestDemo1
                * String getServletPath()
            4. 获取get方式请求参数：name=zhangsan
                * String getQueryString()
            5. (*)获取请求URI：/day14/demo1
                * String getRequestURI():		/day14/requestDemo1
                * StringBuffer getRequestURL()  :http://localhost/day14/requestDemo1
            6. 获取协议及版本：HTTP/1.1
                * String getProtocol()

            7. 获取客户机的IP地址：
                * String getRemoteAddr()

         */
        //1. 获取请求方式 ：GET
        val method: String? = req?.method
        println(method)
        //2.(*)获取虚拟目录：/day14
        //2.(*)获取虚拟目录：/day14
        val contextPath: String? = req?.contextPath
        println(contextPath)
        //3. 获取Servlet路径: /demo1
        //3. 获取Servlet路径: /demo1
        //4. 获取get方式请求参数：name=zhangsan
        //4. 获取get方式请求参数：name=zhangsan
        val queryString: String? = req?.queryString
        println(queryString)
        //5.(*)获取请求URI：/day14/demo1
        //5.(*)获取请求URI：/day14/demo1
        val requestURI: String? = req?.requestURI
        val requestURL: StringBuffer? = req?.requestURL
        println(requestURI)
        println(requestURL)
        //6. 获取协议及版本：HTTP/1.1
        //6. 获取协议及版本：HTTP/1.1
        val protocol: String? = req?.protocol
        println(protocol)
        //7. 获取客户机的IP地址：
        //7. 获取客户机的IP地址：
        val remoteAddr: String? = req?.remoteAddr
        println(remoteAddr)


        //2.获取所以请求头
        val headers:Enumeration<String> =req!!.headerNames;
        while (headers.hasMoreElements()){
            val name = headers.nextElement()
            val value =req.getHeader(name)
            println("name = ${name}  value = ${ value}")
        }

        //3.user-agent
        val agent= req.getHeader("user-agent");
        //判断agent的浏览器版本
        if(agent.contains("Chrome")){
           println("谷歌来了...");
        }else if(agent.contains("Firefox")){
           println("火狐来了...");
        }

        //referer 请求从哪里来，
        val referer = req.getHeader("referer")
        println("referer ${referer}")
       //防盗链
        if (referer.contains("localhost")){
            //正常访问
            resp?.contentType = "text/html:charset=utf-8"
            resp?.writer?.write("播放电影")
        }else{
            resp?.contentType = "text/html:charset=utf-8"
            resp?.writer?.write("想看电影吗？来xx")
        }

        //4.设置流的编码
        req.characterEncoding="utf-8";

        //请求转发
        req.setAttribute("msg","forward")
        req.getRequestDispatcher("/forward").forward(req,resp)
    }

    override fun doPost(req: HttpServletRequest?, resp: HttpServletResponse?) {
        println("doPost")
    }
}