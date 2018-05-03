package com.suyuwei.forage_ssh.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.suyuwei.forage_ssh.dao.FeederProblemJPA;
import com.suyuwei.forage_ssh.entity.FeederProblemEntity;
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
public class FeederProblemService {
    @Autowired
    private FeederProblemJPA feederProblemJPA;

    //添加喂饲人员的反馈问题
    public int feederProblemAdd(HttpServletRequest request) throws IOException {
        BufferedReader reader=request.getReader();
        String input;
        StringBuffer requestBody=new StringBuffer();
        while((input = reader.readLine()) != null) {
            requestBody.append(input);
        }
        JSONArray jsonArray=JSONArray.parseArray(requestBody.toString());
        JSONObject jsonObject=jsonArray.getJSONObject(0);

        String place=jsonObject.getString("place");
        String type=jsonObject.getString("type");
        String remark=jsonObject.getString("remark");
        //获取饲养员姓名即登陆者姓名
        HttpSession session=request.getSession(false);
        //String feederName=(String)session.getAttribute("feederName");
        String feederName="xiaoming";
        //生成时间字符串
        Date day=new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time=sdf.format(day);

        FeederProblemEntity feederProblemEntity=new FeederProblemEntity();
        feederProblemEntity.setFeederName(feederName);
        feederProblemEntity.setPlace(place);
        feederProblemEntity.setType(type);
        feederProblemEntity.setRemark(remark);
        feederProblemEntity.setTime(time);
        feederProblemJPA.save(feederProblemEntity);

        return 0;
    }

    //查询喂饲人员所反馈的问题
    public List<FeederProblemEntity> feederProblemGet(){
        List<FeederProblemEntity> feederProblemEntityList;
        feederProblemEntityList=feederProblemJPA.findAll();
        return feederProblemEntityList;
    }
}
