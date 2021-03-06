package com.suyuwei.forage_ssh.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.suyuwei.forage_ssh.dao.ForageStoreJPA;
import com.suyuwei.forage_ssh.entity.ForageInfomationEntity;
import com.suyuwei.forage_ssh.entity.ForageStoreEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ForageStoreService {
    @Autowired
    private ForageStoreJPA forageStoreJPA;

    //添加、更新饲料储量
    public int forageStoreSave(String requestString) throws IOException {
        JSONArray jsonArray=JSONArray.parseArray(requestString);
        JSONObject jsonObject=jsonArray.getJSONObject(0);
        String type=jsonObject.getString("type");
        Long number=jsonObject.getLong("number");
        String unit=jsonObject.getString("unit");
        //生成时间字符串
        Date day=new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time=sdf.format(day);
        ForageStoreEntity forageStoreEntity=forageStoreJPA.findbytype(type);
        if(forageStoreEntity!=null){
            forageStoreEntity.setNumber(forageStoreEntity.getNumber()+number);
            forageStoreEntity.setTime(time);
            forageStoreJPA.save(forageStoreEntity);
        }else{
            forageStoreEntity=new ForageStoreEntity();
            forageStoreEntity.setType(type);
            forageStoreEntity.setNumber(number);
            forageStoreEntity.setUnit(unit);
            forageStoreEntity.setTime(time);
            forageStoreJPA.save(forageStoreEntity);
        }
        return 0;
    }

    //减少饲料储量，在饲料发放时用到
    public int forageStoreProvide(String requestString) throws IOException {
        JSONArray jsonArray=JSONArray.parseArray(requestString);
        for(int i=0;i<jsonArray.size();i++){
            JSONObject jsonObject=jsonArray.getJSONObject(i);
            String type=jsonObject.getString("type");
            Long number=jsonObject.getLong("number");
            String unit=jsonObject.getString("unit");
            //生成时间字符串
            Date day=new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String time=sdf.format(day);

            ForageStoreEntity forageStoreEntity=forageStoreJPA.findbytype(type);
            if(forageStoreEntity!=null){
                forageStoreEntity.setNumber(forageStoreEntity.getNumber()-number);
                forageStoreEntity.setTime(time);
                forageStoreJPA.save(forageStoreEntity);
            }else{
                forageStoreEntity=new ForageStoreEntity();
                forageStoreEntity.setType(type);
                forageStoreEntity.setNumber(number);
                forageStoreEntity.setUnit(unit);
                forageStoreEntity.setTime(time);
                forageStoreJPA.save(forageStoreEntity);
            }
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

    //手动人工更新饲料储量
    public int forageStoreUpdate(HttpServletRequest request) throws IOException {
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
        Long number=jsonObject.getLong("number");
        String unit=jsonObject.getString("unit");
        //生成时间字符串
        Date day=new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time=sdf.format(day);

        ForageStoreEntity forageStoreEntity=new ForageStoreEntity();
        forageStoreEntity.setId(id);
        forageStoreEntity.setType(type);
        forageStoreEntity.setNumber(number);
        forageStoreEntity.setUnit(unit);
        forageStoreEntity.setTime(time);
        forageStoreJPA.save(forageStoreEntity);
        return 0;
    }
}
