package com.suyuwei.forage_ssh.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.suyuwei.forage_ssh.dao.FeederForageGainJPA;
import com.suyuwei.forage_ssh.dao.FeederProblemJPA;
import com.suyuwei.forage_ssh.entity.FeederForageGainEntity;
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
public class FeederForageGainService {
    @Autowired
    private FeederForageGainJPA feederForageGainJPA;

    //添加饲养员饲料领取记录
    public int feederForageGainAdd(HttpServletRequest request) throws IOException {
        BufferedReader reader=request.getReader();
        String input;
        StringBuffer requestBody=new StringBuffer();
        while((input = reader.readLine()) != null) {
            requestBody.append(input);
        }
        String requestString=requestBody.toString();
        JSONArray jsonArray=JSONArray.parseArray(requestString);
        //生成时间字符串
        Date day=new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time=sdf.format(day);
        //获取饲养员姓名
        HttpSession session=request.getSession(false);
        //String feederName=(String)session.getAttribute("feederName");
        String feederName="xiaoming";

        for(int i=0;i<jsonArray.size();i++){
            FeederForageGainEntity feederForageGainEntity=new FeederForageGainEntity();
            JSONObject jsonObject=jsonArray.getJSONObject(i);
            String type=jsonObject.getString("type");
            Long number=jsonObject.getLong("number");
            String unit=jsonObject.getString("unit");

            feederForageGainEntity.setFeederName(feederName);
            feederForageGainEntity.setType(type);
            feederForageGainEntity.setNumber(number);
            feederForageGainEntity.setUnit(unit);
            feederForageGainEntity.setTime(time);
            feederForageGainJPA.save(feederForageGainEntity);
        }
        return 0;
    }

    //获取所有饲养员领取饲料记录
    public List<FeederForageGainEntity> feederForageGainGet(){
        List<FeederForageGainEntity> feederForageGainEntityList;
        feederForageGainEntityList=feederForageGainJPA.findAll();
        return feederForageGainEntityList;
    }
}
