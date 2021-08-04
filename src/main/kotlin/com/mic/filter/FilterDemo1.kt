package com.mic.filter

import javax.servlet.*
import javax.servlet.annotation.WebFilter

@WebFilter("/*") //访问所有资源之前，都会执行该过滤器
//@WebFilter("/index.jsp") //1. 具体资源路径： /index.jsp   只有访问index.jsp资源时，过滤器才会被执行
//@WebFilter("/user/*") //2. 拦截目录： /user/*	访问/user下的所有资源时，过滤器都会被执行
//@WebFilter("*.jsp")   //3. 后缀名拦截： *.jsp		访问所有后缀名为jsp资源时，过滤器都会被执行

//浏览器直接请求index.jsp资源时，该过滤器会被执行
//@WebFilter(value="/index.jsp",dispatcherTypes = DispatcherType.REQUEST)
//只有转发访问index.jsp时，该过滤器才会被执行
//@WebFilter(value="/index.jsp",dispatcherTypes = DispatcherType.FORWARD)

//浏览器直接请求index.jsp或者转发访问index.jsp。该过滤器才会被执行
//@WebFilter(value="/*",dispatcherTypes ={ DispatcherType.FORWARD,DispatcherType.REQUEST})
class FilterDemo1:Filter {

    override fun init(filterConfig: FilterConfig?) {
          println("filter init")
          println(filterConfig?.filterName)
    }

    override fun destroy() {
        println("destroy")
    }

    override fun doFilter(req: ServletRequest?, resp: ServletResponse?, chain: FilterChain?) {
        println("doFilter 对req增强")
        //放行
        chain?.doFilter(req,resp)

        println("doFilter 对resp增强")
    }
}