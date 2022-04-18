package com.xu.web;

import com.alibaba.fastjson.JSON;
import com.xu.pojo.Brand;
import com.xu.pojo.pageBean;
import com.xu.service.BrandService;
import com.xu.service.impl.BrandServiceImpl;
import com.xu.web.Servlet.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/brand/*")
public class BrandServlet extends BaseServlet {
    private BrandService brandService = new BrandServiceImpl();
    public void selectAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取数据库的全部用户，得到一个List<Brand>集合
        List<Brand> brands = brandService.selectAll();

        //把List<Brand>集合转换成JSON数据
        //设置编码
        resp.setContentType("text/json;charset=utf-8");
        String JsonStr = JSON.toJSONString(brands);
        resp.getWriter().write(JsonStr);

    }
    public void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //接收提交的品牌数据
        BufferedReader reader = req.getReader();
        String brandStr = reader.readLine();//读取一行提交数据
        //把读取的JSON数据反序列化成Brand对象
        Brand brand = JSON.parseObject(brandStr, Brand.class);
        //调用提交方法
        brandService.add(brand);
        //响应一个成功的标识
        resp.getWriter().write("success");
    }

    //批量删除
    public void deleteByIds(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //接收提交的品牌数据
        BufferedReader reader = req.getReader();
        String brandStr = reader.readLine();//读取一行提交数据
        //把读取的JSON数据转换成int[]
        int[] ids = JSON.parseObject(brandStr, int[].class);
        //调用提交方法
        brandService.deleteById(ids);
        //响应一个成功的标识
        resp.getWriter().write("success");
    }

    //分页查询
    public void selectByPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //接收参数   url?currentPage=1&pageSize=5
        String _currentPage = req.getParameter("currentPage");
        String _pageSize = req.getParameter("pageSize");
        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);

        //调用selectByPage方法
        pageBean<Brand> brandpageBean = brandService.selectByPage(currentPage, pageSize);

        //把List<Brand>集合转换成JSON数据
        //设置编码
        resp.setContentType("text/json;charset=utf-8");
        String JsonStr = JSON.toJSONString(brandpageBean);
        resp.getWriter().write(JsonStr);

    }


    //分页查询
    public void selectByPageAndCondition(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收参数   url?currentPage=1&pageSize=5
        String _currentPage = req.getParameter("currentPage");
        String _pageSize = req.getParameter("pageSize");
        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);

        //获取浏览器请求参数中的post参数
        //接收提交的品牌数据
        BufferedReader reader = req.getReader();
        String brandStr = reader.readLine();//读取一行提交数据
        //把读取的JSON数据转换成Brand对象
        Brand brand = JSON.parseObject(brandStr, Brand.class);
        //调用selectByPage方法
        pageBean<Brand> brandpageBean = brandService.selectByPageAndCondition(currentPage, pageSize, brand);
        //把List<Brand>集合转换成JSON数据
        //设置编码
        resp.setContentType("text/json;charset=utf-8");
        String JsonStr = JSON.toJSONString(brandpageBean);
        resp.getWriter().write(JsonStr);
    }

    //查询单条数据
    public void selectSingle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //先获取请求的信息id


        //获取数据库单条数据
        //Brand brand = brandService.selectSingle(id);

        //把List<Brand>集合转换成JSON数据
        //设置编码
//        resp.setContentType("text/json;charset=utf-8");
//        String JsonStr = JSON.toJSONString(brands);
//        resp.getWriter().write(JsonStr);

    }

    //删除单条数据
    public void deleteOneId(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //先获取请求的信息id
//        BufferedReader reader = req.getReader();
//        String brandStr = reader.readLine();//读取一行提交数据
//
//        System.out.println(brandStr);
//        int id = Integer.parseInt(idStr);
//
//        brandService.deleteOneId(id);
//
//        resp.getWriter().write("success");

    }
}
