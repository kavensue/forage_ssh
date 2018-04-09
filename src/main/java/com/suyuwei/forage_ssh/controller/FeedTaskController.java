package com.suyuwei.forage_ssh.controller;

import com.suyuwei.forage_ssh.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class FeedTaskController {
    @Autowired
    private TaskService taskService;
    //重定向
    @RequestMapping(value = "/feedtask",method = RequestMethod.GET)
    public String feedTask(HttpServletResponse response){
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        return "/feedtask";
    }

    @RequestMapping(value = "/feedtasksave",method = RequestMethod.POST)
    @ResponseBody
    public String feedTaskSave(HttpServletRequest request) throws IOException {
        taskService.feedTaskSave(request);
        return "success!";
    }
}
