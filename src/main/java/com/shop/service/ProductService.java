package com.shop.service;

import com.shop.pojo.Category;
import com.shop.pojo.PageInfo;

import java.util.List;

public interface ProductService {
    /**
     * 分页分类型展示页面
     * @param pageNumStr    当前页码
     * @param category      当前类型
     * @return      返回的是整个分页类对象，用于往客户端传递
     */
    PageInfo showPage(String pageNumStr,String category);

    /**
     * 获取数据库中所有的类型，用于类型展示
     * @return  返回类型的集合
     */
    List<Category> getCategory();
}
