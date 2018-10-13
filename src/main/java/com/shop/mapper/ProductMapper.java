package com.shop.mapper;

import com.shop.pojo.Category;
import com.shop.pojo.PageInfo;
import com.shop.pojo.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ProductMapper {
    @Select("select product_id id,product_name name,product_price price,product_inventory inventory,product_status status,p.category_id cid,c.category_id `category.id`,category_name `category.name`,product_pic pic from product_info p join product_category c on p.category_id = c.category_id  where category_name = #{category} limit #{pageStart},#{pageSize}")
    public List<Product> selByPage(PageInfo pageInfo);

    @Select("select count(*) from product_info p join product_category c on p.category_id = c.category_id where category_name = #{category}")
    public int selCount(String category);

    @Select("select category_id id,category_name name from product_category where category_id=#{0}")
    public Category selById(int id);

    @Select("select category_id id,category_name name from product_category")
    public List<Category> selAllCategory();

}
