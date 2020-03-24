package com.aistar.service.Impl;

import com.aistar.mapper.ProductMapper;
import com.aistar.pojo.Product;
import com.aistar.pojo.ProductExample;
import com.aistar.service.ProductAjaxService;
import com.aistar.util.MyBatisUtil;
import com.aistar.util.ServerResponse;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class ProductAjaxServiceImpl implements ProductAjaxService {
    @Override
    public ServerResponse add(Product product) {
        SqlSession sqlSession =  MyBatisUtil.getSqlSession();
        ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);
        Integer rows = mapper.insert(product);
        sqlSession.commit();
        MyBatisUtil.closeSqlSession();
        if (rows>0){
            return ServerResponse.addSuccess();
        }else {
            return  ServerResponse.addFailed();
        }
    }

    @Override
    public ServerResponse update(Product product) {
        SqlSession sqlSession =  MyBatisUtil.getSqlSession();
        ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);
        Integer rows = mapper.updateByPrimaryKey(product);
        sqlSession.commit();
        MyBatisUtil.closeSqlSession();
        if (rows>0){
            return ServerResponse.updateSuccess();
        }else {
            return  ServerResponse.updateFailed();
        }
    }

    @Override
    public ServerResponse delete(String proId) {
        SqlSession sqlSession =  MyBatisUtil.getSqlSession();
        ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);
        Product product = mapper.selectByPrimaryKey(proId);
        if (product!=null){
            product.setProNum(0L);
        }
        Integer rows = mapper.updateByPrimaryKey(product);
        sqlSession.commit();
        MyBatisUtil.closeSqlSession();
        if (rows>0){
            return ServerResponse.deleteSuccess();
        }else {
            return  ServerResponse.deleteFailed();
        }
    }

    @Override
    public ServerResponse getById(String proId) {
        SqlSession sqlSession =  MyBatisUtil.getSqlSession();
        ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);
        Product product =  mapper.selectByPrimaryKey(proId);
        Boolean res = product.getProNum()==0L?false:true;
        if (res){
            return  ServerResponse.getDataSuccess(product);

        }else {
            return ServerResponse.getDataFailed();
        }
    }

    @Override
    public ServerResponse getAllByPage(Integer pageNum) {
        SqlSession sqlSession =  MyBatisUtil.getSqlSession();
        ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);
        Page<Product> page = PageHelper.startPage(pageNum,5);

        ProductExample productExample = new ProductExample();
        ProductExample.Criteria criteria = productExample.createCriteria();
        criteria.andProNumNotEqualTo(0L);

        List<Product> productList = mapper.selectByExample(productExample);

        PageInfo<Product> pageInfo = page.toPageInfo();
        if (productList !=null&& productList.size()>0){
            return ServerResponse.getDataSuccess(pageInfo);
        }else {
            return  ServerResponse.getDataFailed();
        }
    }


    @Override
    public ServerResponse getAll() {
        return null;
    }
}
