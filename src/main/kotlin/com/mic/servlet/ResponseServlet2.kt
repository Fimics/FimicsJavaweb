package com.mic.servlet

import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import java.io.PrintWriter
import javax.servlet.ServletOutputStream
import javax.servlet.ServletContext





@WebServlet("/response2")
class ResponseServlet2:HttpServlet() {

    override fun doGet(req: HttpServletRequest?, resp: HttpServletResponse?) {
       doPost(req,resp)
    }

    override fun doPost(req: HttpServletRequest?, resp: HttpServletResponse?) {
        //获取流对象之前，设置流的默认编码：ISO-8859-1 设置为：GBK
        // response.setCharacterEncoding("utf-8");

        //告诉浏览器，服务器发送的消息体数据的编码。建议浏览器使用该编码解码
        //response.setHeader("content-type","text/html;charset=utf-8");

        //简单的形式，设置编码
        //获取流对象之前，设置流的默认编码：ISO-8859-1 设置为：GBK
        // response.setCharacterEncoding("utf-8");

        //告诉浏览器，服务器发送的消息体数据的编码。建议浏览器使用该编码解码
        //response.setHeader("content-type","text/html;charset=utf-8");

        //简单的形式，设置编码
        resp?.setContentType("text/html;charset=utf-8")

        //1.获取字符输出流

        //1.获取字符输出流
        val pw: PrintWriter? = resp?.getWriter()
        //2.输出数据
        //pw.write("<h1>hello response</h1>");
        //2.输出数据
        //pw.write("<h1>hello response</h1>");
        pw?.write("你好啊啊啊 response")
        println("response2...")
        val msg = req?.getAttribute("msg")
        println(msg)

        val context = this.servletContext
        val msg2 = context.getAttribute("msg2")
        println(msg2)

        //1.获取字节输出流
//        ServletOutputStream sos = response.getOutputStream();
//        //2.输出数据
//        sos.write("你好".getBytes("utf-8"))

        // 通过HttpServlet获取
        // 通过HttpServlet获取
//        val context = this.servletContext


        // 获取文件的服务器路径

//
//        // 获取文件的服务器路径
//        val b = context.getRealPath("/b.txt") //web目录下资源访问
//
//        println(b)
//        // File file = new File(realPath);
//
//        // File file = new File(realPath);
//        val c = context.getRealPath("/WEB-INF/c.txt") //WEB-INF目录下的资源访问
//
//        println(c)
//
//        val a = context.getRealPath("/WEB-INF/classes/a.txt") //src目录下的资源访问
//
//        println(a)
    }
}