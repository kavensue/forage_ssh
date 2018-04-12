package com.suyuwei.forage_ssh.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.suyuwei.forage_ssh.dao.ForageJPA;
import com.suyuwei.forage_ssh.entity.ForageEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@Service
public class ForageService {
    @Autowired
    private ForageJPA forageJPA;

    //饲料属性增加
    public int forageListAdd(HttpServletRequest request) throws IOException {
        BufferedReader reader=request.getReader();
        String input;
        StringBuffer requestBody=new StringBuffer();
        while((input = reader.readLine()) != null) {
            requestBody.append(input);
        }
        JSONArray jsonArray=JSONArray.parseArray(requestBody.toString());
        JSONObject jsonObject=jsonArray.getJSONObject(0);
        Long id=jsonObject.getLong("id");
        String type=jsonObject.getString("type");
        String unit=jsonObject.getString("unit");

        ForageEntity forageEntity = new ForageEntity();
        forageEntity.setType(type);
        forageEntity.setUnit(unit);
        forageJPA.save(forageEntity);

        return 0;
    }

    //饲料属性删除
    public int forageListDelete(HttpServletRequest request) throws IOException {
        String forageId=request.getParameter("id");
        Long id=Long.valueOf(forageId);
        forageJPA.delete(id);
        return 0;
    }

    //饲料属性查询
    public List<ForageEntity> forageListGet(HttpServletRequest request){
        List<ForageEntity> forageEntityList;
        forageEntityList=forageJPA.findAll();
        return forageEntityList;
    }

    //饲料属性修改
    public int forageListUpdate (HttpServletRequest request) throws IOException {
        BufferedReader reader=request.getReader();
        String input;
        StringBuffer requestBody=new StringBuffer();
        while((input = reader.readLine()) != null) {
            requestBody.append(input);
        }
        JSONArray jsonArray=JSONArray.parseArray(requestBody.toString());
        JSONObject jsonObject=jsonArray.getJSONObject(0);
        Long id=jsonObject.getLong("id");
        String type=jsonObject.getString("type");
        String unit=jsonObject.getString("unit");

        ForageEntity forageEntity = new ForageEntity();
        forageEntity.setId(id);
        forageEntity.setType(type);
        forageEntity.setUnit(unit);
        forageJPA.save(forageEntity);

        return 0;
    }
}
