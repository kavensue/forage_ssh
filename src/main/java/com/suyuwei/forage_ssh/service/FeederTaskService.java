package com.suyuwei.forage_ssh.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.suyuwei.forage_ssh.dao.FeederTaskJPA;
import com.suyuwei.forage_ssh.entity.FeederTaskEntity;
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
public class FeederTaskService {
    @Autowired
    private FeederTaskJPA feederTaskJPA;

    //添加饲养任务
    public int feederTaskAdd(HttpServletRequest request) throws IOException {
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
            FeederTaskEntity feederTaskEntity=new FeederTaskEntity();
            JSONObject jsonObject=jsonArray.getJSONObject(i);
            String place=jsonObject.getString("place");
            String target=jsonObject.getString("target");
            String note=jsonObject.getString("note");

            feederTaskEntity.setFeederName(feederName);
            feederTaskEntity.setPlace(place);
            feederTaskEntity.setTarget(target);
            feederTaskEntity.setTime(time);
            feederTaskEntity.setNote(note);
            feederTaskJPA.save(feederTaskEntity);
        }

        return 0;
    }

    //获取所有饲养任务
    public List<FeederTaskEntity> feederTaskGet(){
        List<FeederTaskEntity> feederTaskEntityList=feederTaskJPA.findAll();
        return feederTaskEntityList;
    }

}
