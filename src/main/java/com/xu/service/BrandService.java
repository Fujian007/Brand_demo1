package com.xu.service;

import com.xu.pojo.Brand;
import com.xu.pojo.pageBean;


import java.util.List;

public interface BrandService {
    //查询所有
    List<Brand> selectAll();

    //添加数据
    void add(Brand brand);

    //完成批量删除
    void deleteById(int[] ids);

    //分页查询
    pageBean<Brand> selectByPage(int currentPage,int pageSize);

    //分页条件查询
    pageBean<Brand> selectByPageAndCondition(int currentPage,int pageSize,Brand brand);

   //查询单条数据对象
    Brand selectSingle(int id);

    //删除单个数据
    void deleteOneId(int id);


}
