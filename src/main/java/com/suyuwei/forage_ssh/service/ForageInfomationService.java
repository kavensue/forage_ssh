package com.suyuwei.forage_ssh.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.suyuwei.forage_ssh.dao.ForageInfomationJPA;
import com.suyuwei.forage_ssh.entity.ForageInfomationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ForageInfomationService {
    @Autowired
    private ForageInfomationJPA forageInfomationJPA;

    //添加饲料出入库信息
    public int forageInfomationAdd(HttpServletRequest request) throws IOException {
        BufferedReader reader=request.getReader();
        String input;
        StringBuffer requestBody=new StringBuffer();
        while((input = reader.readLine()) != null) {
            requestBody.append(input);
        }
        JSONArray jsonArray=JSONArray.parseArray(requestBody.toString());
        JSONObject jsonObject=jsonArray.getJSONObject(0);
        String type=jsonObject.getString("type");
        Long number=jsonObject.getLong("number");
        String unit=jsonObject.getString("unit");
        //生成时间字符串
        Date day=new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time=sdf.format(day);
        //获取仓库管理员姓名
        HttpSession session=request.getSession(false);
        String adminName = (String) session.getAttribute("adminName");

        ForageInfomationEntity forageInfomationEntity=new ForageInfomationEntity();
        forageInfomationEntity.setType(type);
        forageInfomationEntity.setNumber(number);
        forageInfomationEntity.setUnit(unit);
        forageInfomationEntity.setTime(time);
        forageInfomationEntity.setAdminName(adminName);
        forageInfomationJPA.save(forageInfomationEntity);

        return 0;
    }

    //删除饲料出入库信息
    public int forageInfomationDelete(HttpServletRequest request){
        String forageInfomationId=request.getParameter("id");
        Long id=Long.valueOf(forageInfomationId);
        forageInfomationJPA.delete(id);
        return 0;
    }

    //查看饲料出入库信息
    public List<ForageInfomationEntity> forageInfomationGet(){
        List<ForageInfomationEntity> forageInfomationEntityList=forageInfomationJPA.findAll();
        return forageInfomationEntityList;
    }
}
