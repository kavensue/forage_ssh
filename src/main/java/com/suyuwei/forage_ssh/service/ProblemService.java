package com.suyuwei.forage_ssh.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.suyuwei.forage_ssh.dao.ProblemJPA;
import com.suyuwei.forage_ssh.entity.ProblemEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@Service
public class ProblemService {
    @Autowired
    private ProblemJPA problemJPA;

    //问题属性添加
    public int problemAdd(HttpServletRequest request) throws IOException {
        BufferedReader reader=request.getReader();
        String input;
        StringBuffer requestBody=new StringBuffer();
        while((input = reader.readLine()) != null) {
            requestBody.append(input);
        }
        JSONArray jsonArray=JSONArray.parseArray(requestBody.toString());
        JSONObject jsonObject=jsonArray.getJSONObject(0);

        String place = jsonObject.getString("place");
        String type=jsonObject.getString("type");

        ProblemEntity problemEntity=new ProblemEntity();
        problemEntity.setPlace(place);
        problemEntity.setType(type);
        problemJPA.save(problemEntity);

        return 0;
    }

    //问题属性删除
    public int problemDelete(HttpServletRequest request) throws IOException {
        String problemId=request.getParameter("id");
        Long id=Long.valueOf(problemId);
        problemJPA.delete(id);
        return 0;
    }

    //问题属性查询
    public List<ProblemEntity> problemGet(){
        List<ProblemEntity> problemEntityList;
        problemEntityList=problemJPA.findAll();
        return problemEntityList;
    }

    //问题属性更新
    public int problemUpdate(HttpServletRequest request) throws IOException {
        BufferedReader reader=request.getReader();
        String input;
        StringBuffer requestBody=new StringBuffer();
        while((input = reader.readLine()) != null) {
            requestBody.append(input);
        }
        JSONArray jsonArray=JSONArray.parseArray(requestBody.toString());
        JSONObject jsonObject=jsonArray.getJSONObject(0);

        Long id=jsonObject.getLong("id");
        String place=jsonObject.getString("place");
        String type=jsonObject.getString("type");

        ProblemEntity problemEntity=new ProblemEntity();
        problemEntity.setId(id);
        problemEntity.setPlace(place);
        problemEntity.setType(type);
        problemJPA.save(problemEntity);

        return 0;
    }
}
