package com.suyuwei.forage_ssh.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.suyuwei.forage_ssh.dao.TaskJPA;
import com.suyuwei.forage_ssh.entity.TaskEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskJPA taskJPA;

    //任务属性添加
    public int taskAdd(HttpServletRequest request) throws IOException {
        BufferedReader reader=request.getReader();
        String input;
        StringBuffer requestBody=new StringBuffer();
        while((input = reader.readLine()) != null) {
            requestBody.append(input);
        }
        JSONArray jsonArray=JSONArray.parseArray(requestBody.toString());
        JSONObject jsonObject=jsonArray.getJSONObject(0);

        String place=jsonObject.getString("place");
        String target=jsonObject.getString("target");

        TaskEntity taskEntity=new TaskEntity();
        taskEntity.setPlace(place);
        taskEntity.setTarget(target);

        taskJPA.save(taskEntity);

        return 0;
    }

    //任务属性删除
    public int taskDelete(HttpServletRequest request) throws IOException {
        String taskId=request.getParameter("id");
        Long id=Long.valueOf(taskId);
        taskJPA.delete(id);
        return 0;
    }

    //任务属性查询
    public List<TaskEntity> taskGet(){
        List<TaskEntity> taskEntityList;
        taskEntityList=taskJPA.findAll();
        return taskEntityList;
    }

    //任务属性更新
    public int taskUpdate(HttpServletRequest request) throws IOException {
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
        String target=jsonObject.getString("target");

        TaskEntity taskEntity=new TaskEntity();
        taskEntity.setId(id);
        taskEntity.setPlace(place);
        taskEntity.setTarget(target);

        taskJPA.save(taskEntity);

        return 0;
    }
}
