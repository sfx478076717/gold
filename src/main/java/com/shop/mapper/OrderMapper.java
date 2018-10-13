package com.shop.mapper;

import com.shop.pojo.Detail;
import com.shop.pojo.Order;
import com.shop.pojo.Product;
import com.shop.pojo.VIP;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface OrderMapper {
    @Insert("insert order_master values(default,#{bid},#{amount},#{createTime})")
    public int insOrder(Order order);

    @Insert("insert order_detail values(default,#{oid},#{pid},#{pname},#{price},#{number})")
    public int insDetail(Detail detail);

    @Update("update vip_info set vip_balance = #{balance} where vip_phone = #{phone}")
    public int updVIP(VIP vip);

    @Update("update product_info set product_inventory = product_inventory - #{number} where product_id = #{pid}")
    public int updProduct(Detail detail);

    @Select("select LAST_INSERT_ID()")
    public int selLastInsId();

    @Select("select vip_id id,vip_name name,vip_phone phone,vip_balance balance from vip_info where vip_phone = #{phone}")
    public VIP selAllByPhone(String phone);

    @Select("select product_id id,product_name name,product_price price,product_inventory inventory,product_status status,category_id cid from product_info where product_id = #{pid}")
    public Product selAllByPid(int pid);
}
