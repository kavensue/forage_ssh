package com.suyuwei.forage_ssh.controller;

import com.suyuwei.forage_ssh.entity.FeederProblemEntity;
import com.suyuwei.forage_ssh.service.FeederProblemService;
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
}
