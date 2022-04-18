package com.xu.service.impl;

import com.xu.mapper.BrandMapper;
import com.xu.pojo.Brand;
import com.xu.pojo.pageBean;
import com.xu.service.BrandService;
import com.xu.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class BrandServiceImpl implements BrandService {
    private SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
    //编写一个返回所有用户的方法
    public List<Brand> selectAll(){

        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        List<Brand> brands = mapper.selectAll();
        sqlSession.close();//释放资源
        return brands;
    }

    @Override
    public void add(Brand brand) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        mapper.add(brand);//调用方法
        sqlSession.commit();//提交事务
        sqlSession.close();//释放资源

    }

    @Override
    public void deleteById(int[] ids) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        mapper.deleteById(ids);//调用方法
        sqlSession.commit();//提交事务
        sqlSession.close();//释放资源
    }

    @Override
    public pageBean<Brand> selectByPage(int currentPage, int pageSize) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        int begin = (currentPage - 1) * pageSize;
        //int size = pageSize;
        List<Brand> rows = mapper.selectByPage(begin, pageSize);

        //获取总数
        int totalCount = mapper.selectTotalCount();
        pageBean<Brand> pageBean = new pageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);


        sqlSession.close();

        return pageBean;

    }

    @Override
    public pageBean<Brand> selectByPageAndCondition(int currentPage, int pageSize, Brand brand) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        int begin = (currentPage - 1) * pageSize;
        //int size = pageSize;

        //进行模糊查询需要对品牌名称和公司名称加百分号， 例如 "%小米%"
        String brandName = brand.getBrandName();
        if (brandName != null && brandName.length() > 0) {
            brand.setBrandName("%" + brandName + "%");
        }
        String companyName = brand.getCompanyName();
        if (companyName != null && companyName.length() > 0) {
            brand.setCompanyName("%" + companyName + "%");
        }

        List<Brand> rows = mapper.selectByPageAndCondition(begin,pageSize,brand);



        //获取总数
        int totalCount = mapper.selectConditionCount(brand);
        pageBean<Brand> pageBean = new pageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);


        sqlSession.close();

        return pageBean;
    }

    @Override
    public Brand selectSingle(int id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        Brand brand = mapper.selectSingle(id);
        //调用方法
        sqlSession.close();//释放资源
        return brand;
    }

    @Override
    public void deleteOneId(int id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        mapper.deleteOneId(id);

        sqlSession.commit();//提交事务
        sqlSession.close();//释放资源
    }
}
