package com.shop.service.impl;

import com.shop.mapper.ProductMapper;
import com.shop.pojo.Category;
import com.shop.pojo.PageInfo;
import com.shop.pojo.Product;
import com.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("ProductService")
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;
    @Override
    public PageInfo showPage(String pageNumStr,String category) {
        //每页多少个
        int pageSize = 6;
        //当前是第几页
        int pageNum = 1;
        //如果没传入值就用上边定义的默认的第一页，如果传入值则获取值并转换成int格式
        if(pageNumStr != null && !pageNumStr.equals("")){
            pageNum = Integer.parseInt(pageNumStr);
        }
        //如果类型为空，则获取数据库中的第一列的数据
        if(category == null || category.equals("")){
            category = productMapper.selAllCategory().get(0).getName();
        }
        //当前类型共有多少商品
        int count = productMapper.selCount(category);
        //当前页从第几个商品开始
        int pageStart = (pageNum - 1) * pageSize;
        //总共多少页
        int total = count % pageSize == 0 ? count / pageSize : count / pageSize + 1;


        PageInfo pageInfo = new PageInfo();
        pageInfo.setPageNum(pageNum);
        pageInfo.setPageSize(pageSize);
        pageInfo.setTotal(total);
        pageInfo.setPageStart(pageStart);
        pageInfo.setCategory(category);

        //当前页商品集合
        List<Product> list = productMapper.selByPage(pageInfo);
        pageInfo.setList(list);
        return pageInfo;
    }

    public List<Category> getCategory(){
        return productMapper.selAllCategory();
    }
}
