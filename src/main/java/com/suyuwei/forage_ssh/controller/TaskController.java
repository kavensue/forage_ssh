package com.suyuwei.forage_ssh.controller;

import com.suyuwei.forage_ssh.entity.TaskEntity;
import com.suyuwei.forage_ssh.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class TaskController {
    @Autowired
    private TaskService taskService;

    //任务属性添加
    @RequestMapping(value = "/taskAdd",method = RequestMethod.POST)
    @ResponseBody
    public int taskAdd(HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        response.setHeader("Access-Control-Allow-Origin","*");
        return taskService.taskAdd(request);
    }

    //任务属性删除
    @RequestMapping(value = "/taskDelete",method = RequestMethod.GET)
    @ResponseBody
    public int taskDelete(HttpServletRequest request,HttpServletResponse response) throws IOException{
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        response.setHeader("Access-Control-Allow-Origin","*");
        return  taskService.taskDelete(request);
    }

    //任务属性查询
    @RequestMapping(value = "/taskGet",method = RequestMethod.GET)
    @ResponseBody
    public List<TaskEntity> taskGet(HttpServletResponse response){
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        response.setHeader("Access-Control-Allow-Origin","*");
        return taskService.taskGet();
    }

    //任务属性更新
    @RequestMapping(value = "/taskUpdate",method = RequestMethod.POST)
    public int taskUpdate(HttpServletRequest request,HttpServletResponse response) throws IOException{
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        response.setHeader("Access-Control-Allow-Origin","*");
        return taskService.taskUpdate(request);
    }
}
