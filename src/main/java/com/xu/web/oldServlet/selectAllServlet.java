package com.xu.web.oldServlet;

import com.alibaba.fastjson.JSON;
import com.xu.pojo.Brand;
import com.xu.service.BrandService;
import com.xu.service.impl.BrandServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "selectAllServlet", value = "/selectAllServlet")
public class selectAllServlet extends HttpServlet {
    private BrandService brandService = new BrandServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取数据库的全部用户，得到一个List<Brand>集合
        List<Brand> brands = brandService.selectAll();

        //把List<Brand>集合转换成JSON数据
        //设置编码
        response.setContentType("text/json;charset=utf-8");
        String JsonStr = JSON.toJSONString(brands);
        response.getWriter().write(JsonStr);



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
