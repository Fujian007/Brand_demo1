package com.xu.mapper;

import com.xu.pojo.Brand;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BrandMapper {
    //查询所有
    List<Brand> selectAll();

    //添加数据
    void add(Brand brand);

    //完成批量删除
    void deleteById(@Param("ids") int[] ids);

    //分页查询
    List<Brand> selectByPage(@Param("begin") int begin,@Param("size") int size);

    //查询总数
    @Select("select count(*) from tb_brand")
    int selectTotalCount();


    //条件分页查询
    List<Brand> selectByPageAndCondition(@Param("begin") int begin,@Param("size") int size,@Param("brand") Brand brand);

    //条件查询总数
    int selectConditionCount(Brand brand);

    //数据回填，返回单个对象
    Brand selectSingle(int id);

    //删除单个数据
    void deleteOneId(int id);
}
