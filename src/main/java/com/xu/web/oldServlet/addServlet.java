package com.xu.web.oldServlet;

import com.alibaba.fastjson.JSON;
import com.xu.pojo.Brand;
import com.xu.service.BrandService;
import com.xu.service.impl.BrandServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "addServlet", value = "/addServlet")
public class addServlet extends HttpServlet {
    private BrandService brandService = new BrandServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //接收提交的品牌数据
        BufferedReader reader = request.getReader();
        String brandStr = reader.readLine();//读取一行提交数据
        //把读取的数据转换成JSON数据
        Brand brand = JSON.parseObject(brandStr, Brand.class);
        //调用提交方法
        brandService.add(brand);
        //响应一个成功的标识
        response.getWriter().write("success");


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
