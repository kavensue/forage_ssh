package com.suyuwei.forage_ssh.controller;

import com.suyuwei.forage_ssh.entity.ProblemEntity;
import com.suyuwei.forage_ssh.service.ProblemService;
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
public class ProblemController {
    @Autowired
    private ProblemService problemService;

    //问题属性添加
    @RequestMapping(value = "/problemAdd",method = RequestMethod.POST)
    @ResponseBody
    public int problemAdd(HttpServletRequest request,HttpServletResponse response) throws IOException{
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        response.setHeader("Access-Control-Allow-Origin","*");
        return problemService.problemAdd(request);
    }

    //问题属性删除
    @RequestMapping(value = "/problemDelete",method = RequestMethod.GET)
    @ResponseBody
    public int problemDelete(HttpServletRequest request,HttpServletResponse response) throws IOException{
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        response.setHeader("Access-Control-Allow-Origin","*");
        return problemService.problemDelete(request);
    }

    //问题属性查询
    @RequestMapping(value = "/problemGet",method = RequestMethod.GET)
    @ResponseBody
    public List<ProblemEntity> problemGet(HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        response.setHeader("Access-Control-Allow-Origin","*");
        return problemService.problemGet();
    }

    //问题属性更新
    @RequestMapping(value = "/problemUpdate",method = RequestMethod.POST)
    @ResponseBody
    public int problemUpdate(HttpServletRequest request,HttpServletResponse response) throws IOException{
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        response.setHeader("Access-Control-Allow-Origin","*");
        return problemService.problemUpdate(request);
    }
}
