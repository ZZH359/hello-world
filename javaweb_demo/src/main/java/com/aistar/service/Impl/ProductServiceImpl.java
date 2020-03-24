package com.aistar.service.Impl;

import com.aistar.mapper.ProductMapper;
import com.aistar.pojo.Customer;
import com.aistar.pojo.Product;
import com.aistar.service.ProductService;
import com.aistar.util.MyBatisUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class ProductServiceImpl implements ProductService {
    private static List<Product> productList = new ArrayList<>();
    static {
         Product product1 = new Product("111111111","小米电视V3",12345678L,2888.00F,"北京","黑色",65f,new Date());
         Product product2 = new Product("222222222","华为电视P3",12345678L,2888.00f,"苏州","白色",78f,new Date());
         Product product3 = new Product("333333333","创维电视C1",12345678L,2888.00f,"上海","红色",45f,new Date());
         Product product4 = new Product("444444444","索尼电视S5",12345678L,2888.00f,"西安","绿色",21f,new Date());
         Product product5 = new Product("555555555","海尔电视H7",12345678L,2888.00f,"深圳","青色",35f,new Date());
         Product product6 = new Product("666666666","三星电视X3",12345678L,2888.00f,"广州","蓝色",32f,new Date());
         Product product7 = new Product("777777777","康佳电视K4",12345678L,2888.00f,"东京","紫色",50f,new Date());
         Product product8 = new Product("888888888","海信电视HX8",12345678L,2888.00f,"台湾","灰色",62f,new Date());
         Product product9 = new Product("999999999","松下电视SX0",12345678L,2888.00f,"济南","金色",58f,new Date());
         Product product10 = new Product("aaaaaaaaa","长虹电视CH2",12345678L,2888.00f,"天津","银色",60f,new Date());
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        productList.add(product4);
        productList.add(product5);
        productList.add(product6);
        productList.add(product7);
        productList.add(product8);
        productList.add(product9);
        productList.add(product10);
    }

    @Override
    public Page<Product> getAllByPage(Integer pageNum) {
        SqlSession sqlSession =  MyBatisUtil.getSqlSession();
        ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);
        Page<Product> page = PageHelper.startPage(pageNum,5);

        List<Product> productList =  mapper.selectByExample(null); // select * from product limit n,m

        return page;
    }
    @Override
    public Product getById(String id) {
        SqlSession sqlSession =  MyBatisUtil.getSqlSession();
        ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);
        Product product =  mapper.selectByPrimaryKey(id);
        return product;
    }













    @Override
    public List<Product> getAll() {
        SqlSession sqlSession =  MyBatisUtil.getSqlSession();
        ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);
        List<Product> productList = mapper.selectByExample(null);
        return productList;
    }

















    @Override
    public boolean add(Product product) {
        if (product.getProId() !=null){
            productList.add(product);
            return true;
        }
        return false;
    }

    @Override
    public boolean modify(Product product) {
        for (Product p:productList){
            if (p.getProId().equals(product.getProId())){
                productList.remove(p);
                productList.add(product);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        for (Product product:productList){
            if (product.getProId().equals(id)){
                productList.remove(product);
                return true;
            }
        }
        return false;
    }


    @Override
    public Product getById(Integer id) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }
}
