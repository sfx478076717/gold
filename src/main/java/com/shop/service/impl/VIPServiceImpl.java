package com.shop.service.impl;

import javax.annotation.Resource;
import com.shop.mapper.VIPMapper;
import com.shop.pojo.VIP;
import com.shop.service.VIPService;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service("vipService")
public class VIPServiceImpl implements VIPService {

	@Resource
	private VIPMapper vipMapper;

	@Override
	public int addVIP(VIP vip) {
		int index = 0;//返回的行数
		VIP dbVIP = vipMapper.selByPhone(vip.getPhone());//根据手机号查询数据库是否已经存在该用户
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String createTime =sdf.format(new Date());//获取当前时间并转换格式
		vip.setCreateTime(createTime);
		if(dbVIP == null){
			index = vipMapper.insVIP(vip);
		}else{
			vip.setBalance(vip.getBalance() + dbVIP.getBalance());//余额为原会员卡余额加上充值的金额
			index = vipMapper.updVIPByPhone(vip);
		}
		return index;
	}

	@Override
	public VIP selBalance(String phone) {
		return vipMapper.selByPhone(phone);
	}


}
