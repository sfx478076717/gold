package com.shop.controller;

import com.shop.pojo.Detail;
import com.shop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;
    @RequestMapping("/vipPay")
    public String vipPay(String jsonStr, String phone, HttpServletRequest request, HttpServletResponse response){
        //System.out.println(jsonStr);
        //System.out.println(phone);
        Map<String,Integer> map = (Map<String, Integer>) com.alibaba.fastjson.JSON.parse(jsonStr);

        //最开始先判断手机号是否是vip
        if(orderService.judgeVip(phone) == true){
            //再判断库存是否充足，返回库存不充足商品的name
            String name = orderService.judgeInventory(map, phone);
            if(name == "nomal"){
                //再判断余额是否充足
                if(orderService.judgeBalance(map, phone) == true){
                    //再从会员卡中扣钱
                    int vipIndex = orderService.updVIP(map,phone);
                    //然后创建订单表，返回创建的订单表id
                    int lastInsId = orderService.insOrder(map, phone);
                    //最后创建订单详细表
                    List<Detail> list = orderService.insDetail(map,phone,lastInsId);
                    request.setAttribute("successDetail",list);
                    return "/jsp/front/paySuccess.jsp";
                }else{
                    System.out.println("余额不足！");
                    request.setAttribute("message","您余额不足！");
                    return "/show";
                }
            }else{
                System.out.println(name+"库存不足！");
                request.setAttribute("message",name+"库存不足！");
                return "/show";
            }
        }else{
            System.out.println("用户不是vip！");
            request.setAttribute("message","您不是vip！");
            return "/show";
        }
    }
    @RequestMapping("/userPay")
    public String userPay(String jsonStr, String phone, HttpServletRequest request, HttpServletResponse response){
        Map<String,Integer> map = (Map<String, Integer>) com.alibaba.fastjson.JSON.parse(jsonStr);

        //先判断库存是否充足，返回库存不充足商品的name
        String name = orderService.judgeInventory(map, phone);
        if(name == "nomal"){
            //弹出一个页面付款，获取其是否付款成功
            int paySuccess = 1;//是否付款成功的参数，先定义为成功
            if(paySuccess == 1){
                //然后创建订单表，返回创建的订单表id
                int lastInsId = orderService.insOrder(map, phone);
                //最后创建订单详细表
                List<Detail> list = orderService.insDetail(map,phone,lastInsId);
                request.setAttribute("successDetail",list);
                return "/jsp/front/paySuccess.jsp";
            }else{
                request.setAttribute("message","付款失败！");
                return "/show";
            }
        }else{
            request.setAttribute("message",name+"库存不足！");
            return "/show";
        }

    }
}
