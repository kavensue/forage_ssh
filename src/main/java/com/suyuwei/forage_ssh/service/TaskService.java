package com.suyuwei.forage_ssh.service;

import com.alibaba.fastjson.JSONArray;
import com.suyuwei.forage_ssh.dao.FeederTaskJPA;
import com.suyuwei.forage_ssh.entity.FeederTaskEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;

@Service
public class TaskService {
    @Autowired
    private FeederTaskJPA feederTaskJPA;

    public void feedTaskSave(HttpServletRequest request) throws IOException {
        BufferedReader reader=request.getReader();
        String input;
        StringBuffer requestBody=new StringBuffer();
        while((input = reader.readLine()) != null) {
            requestBody.append(input);
        }
        JSONArray jsonArray=JSONArray.parseArray(requestBody.toString());

        String taskListJson=request.getParameter("taskListJson");
        String userName = "xiaoming";
        Long userId = 1L;

        for(int i=0;i<jsonArray.size();i++){
            FeederTaskEntity feederTaskEntity=new FeederTaskEntity();
            feederTaskEntity.setFeederId(userId);
            feederTaskEntity.setFeederName(userName);
            feederTaskEntity.setPlace((String)jsonArray.getJSONArray(i).get(0));
            feederTaskEntity.setTime("2018-04-02 04:09:41");
            feederTaskJPA.save(feederTaskEntity);
        }
    }
}
