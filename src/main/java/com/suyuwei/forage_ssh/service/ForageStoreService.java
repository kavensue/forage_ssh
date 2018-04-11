package com.suyuwei.forage_ssh.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.suyuwei.forage_ssh.dao.ForageStoreJPA;
import com.suyuwei.forage_ssh.entity.ForageStoreEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@Service
public class ForageStoreService {
    @Autowired
    private ForageStoreJPA forageStoreJPA;

    //添加、更新饲料储量
    public int forageStoreSave(HttpServletRequest request) throws IOException {
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
        ForageStoreEntity forageStoreEntity=forageStoreJPA.findbytype(type);
        if(forageStoreEntity!=null){
            forageStoreEntity.setNumber(forageStoreEntity.getNumber()+number);
            forageStoreJPA.save(forageStoreEntity);
        }else{
            forageStoreEntity.setType(type);
            forageStoreEntity.setNumber(number);
            forageStoreEntity.setUnit(unit);
        }
        return 0;
    }

    //删除饲料储量
    public int forageStoreDelete(HttpServletRequest request){
        String forageStoreId=request.getParameter("id");
        Long id=Long.valueOf(forageStoreId);
        forageStoreJPA.delete(id);
        return 0;
    }

    //查询饲料储量
    public List<ForageStoreEntity> forageStoreGet(){
        return forageStoreJPA.findAll();
    }

}
