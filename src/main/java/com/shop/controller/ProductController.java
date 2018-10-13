package com.shop.controller;

import com.shop.pojo.PageInfo;
import com.shop.pojo.Product;
import com.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;
    @RequestMapping("/show")
    public String show(String pageNum, String category,HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        PageInfo pageInfo = productService.showPage(pageNum,category);
        request.setAttribute("pageInfo",pageInfo);
        request.setAttribute("category",productService.getCategory());
        return "/jsp/front/main.jsp";
    }
    @RequestMapping("/refresh")
    public String refresh(String pageNum, String category,HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        PageInfo pageInfo = productService.showPage(pageNum,category);
        request.setAttribute("pageInfo",pageInfo);
        return "/jsp/front/shop.jsp";
    }
}
