package com.xu.web.Servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet {
    //重写HttpServlet中的service方法

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取路径
        String requestURI = req.getRequestURI();
        //获取方法名，就是requestURI中最后一部分内容
        int index = requestURI.lastIndexOf('/');
        String methodName = requestURI.substring(index + 1);

        //调用子类的方法
        //获取子类的class对象
        //通过反射调用其方法
        //System.out.println(this);
        Class<? extends BaseServlet> aClass = this.getClass();
        //得到方法对象
        try {
            Method method = aClass.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this,req,resp);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


    }
}
