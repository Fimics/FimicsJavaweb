package com.mic.listener

import javax.servlet.ServletContextListener
import javax.servlet.annotation.WebListener
import javax.servlet.ServletContextEvent

import java.io.FileInputStream
import java.lang.Exception

import javax.servlet.ServletContext




@WebListener
class ContextLoaderListener:ServletContextListener {

    /**
     * 监听ServletContext对象创建的。ServletContext对象服务器启动后自动创建。
     *
     * 在服务器启动后自动调用
     * @param servletContextEvent
     */
    override fun contextInitialized(servletContextEvent: ServletContextEvent) {
        //加载资源文件
        //1.获取ServletContext对象
        val servletContext = servletContextEvent.servletContext

        //2.加载资源文件
        val contextConfigLocation = servletContext.getInitParameter("contextConfigLocation")

        //3.获取真实路径
        val realPath = servletContext.getRealPath(contextConfigLocation)

        //4.加载进内存
        try {
            val fis = FileInputStream(realPath)
            println(fis)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        println("ServletContext对象被创建了。。。")
    }

    /**
     * 在服务器关闭后，ServletContext对象被销毁。当服务器正常关闭后该方法被调用
     * @param servletContextEvent
     */
    override fun contextDestroyed(servletContextEvent: ServletContextEvent?) {
        println("ServletContext对象被销毁了。。。")
    }
}