package com.suyuwei.forage_ssh.controller;

import com.suyuwei.forage_ssh.entity.FeederForageGainEntity;
import com.suyuwei.forage_ssh.entity.FeederProblemEntity;
import com.suyuwei.forage_ssh.entity.FeederTaskEntity;
import com.suyuwei.forage_ssh.service.FeederForageGainService;
import com.suyuwei.forage_ssh.service.FeederProblemService;
import com.suyuwei.forage_ssh.service.FeederTaskService;
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
public class FeederController {
    @Autowired
    private FeederProblemService feederProblemService;
    @Autowired
    private FeederForageGainService feederForageGainService;
    @Autowired
    private FeederTaskService feederTaskService;

    //添加喂饲人员的反馈问题
    @RequestMapping(value = "/feederProblemAdd",method = RequestMethod.POST)
    @ResponseBody
    public int feederProblemAdd(HttpServletRequest request, HttpServletResponse response) throws IOException {
        feederProblemService.feederProblemAdd(request);
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        response.setHeader("Access-Control-Allow-Origin","*");
        return 0;
    }

    //获得喂饲人员所有的反馈问题
    @RequestMapping(value = "/feederProblemGet",method = RequestMethod.GET)
    @ResponseBody
    public List<FeederProblemEntity> feederProblemGet(HttpServletResponse response){
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        response.setHeader("Access-Control-Allow-Origin","*");
        return feederProblemService.feederProblemGet();
    }

    //添加饲养员领取饲料记录
    @RequestMapping(value = "/feederForageGainAdd",method = RequestMethod.POST)
    @ResponseBody
    public int feederForageGainAdd(HttpServletRequest request,HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        response.setHeader("Access-Control-Allow-Origin","*");
        feederForageGainService.feederForageGainAdd(request);
        return 0;
    }

    //获取饲养员所有领取饲料记录
    @RequestMapping(value = "/feederForageGainGet",method = RequestMethod.GET)
    @ResponseBody
    public List<FeederForageGainEntity> feederForageGainGet(HttpServletResponse response){
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        response.setHeader("Access-Control-Allow-Origin","*");
        return feederForageGainService.feederForageGainGet();
    }

    //添加饲养任务
    @RequestMapping(value = "/feederTaskAdd",method = RequestMethod.POST)
    @ResponseBody
    public int feederTaskAdd(HttpServletRequest request,HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        response.setHeader("Access-Control-Allow-Origin","*");
        feederTaskService.feederTaskAdd(request);
        return 0;
    }

    //获取饲养任务
    @RequestMapping(value = "/feederTaskGet",method = RequestMethod.GET)
    @ResponseBody
    public List<FeederTaskEntity> feederTaskGet(HttpServletResponse response){
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        response.setHeader("Access-Control-Allow-Origin","*");
        return feederTaskService.feederTaskGet();
    }

    //改变饲养任务完成状态
    @RequestMapping(value = "/feederTaskStatusChange",method = RequestMethod.POST)
    @ResponseBody
    public int feederTaskStatusChange(HttpServletRequest request,HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        response.setHeader("Access-Control-Allow-Origin","*");
        return feederTaskService.feederTaskStatusChange(request);
    }
}
