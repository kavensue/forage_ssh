package com.suyuwei.forage_ssh.controller;

import com.suyuwei.forage_ssh.entity.ForageEntity;
import com.suyuwei.forage_ssh.entity.ForageInfomationEntity;
import com.suyuwei.forage_ssh.entity.ForageStoreEntity;
import com.suyuwei.forage_ssh.service.ForageInfomationService;
import com.suyuwei.forage_ssh.service.ForageService;
import com.suyuwei.forage_ssh.service.ForageStoreService;
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
public class AdminController {
    @Autowired
    private ForageService forageService;
    @Autowired
    private ForageStoreService forageStoreService;
    @Autowired
    private ForageInfomationService forageInfomationService;

    //饲料属性添加
    @RequestMapping(value = "/forageAdd",method = RequestMethod.POST)
    @ResponseBody
    public int forageAdd(HttpServletRequest request,HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        return forageService.forageListAdd(request);
    }

    //饲料属性删除
    @RequestMapping(value = "/forageDelete",method = RequestMethod.POST)
    @ResponseBody
    public int forageDelete(HttpServletRequest request,HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        return forageService.forageListDelete(request);
    }

    //饲料属性查询
    @RequestMapping(value = "/forageGet",method = RequestMethod.GET)
    @ResponseBody
    public List<ForageEntity> forageGet(HttpServletRequest request, HttpServletResponse response){
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        return forageService.forageListGet(request);
    }

    //饲料属性更新
    @RequestMapping(value = "/forageUpdate",method = RequestMethod.POST)
    @ResponseBody
    public int forageUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        return forageService.forageListUpdate(request);
    }



    //饲料储量和入库信息增加、更新
    @RequestMapping(value = "/forageStoreAndInfoSave",method = RequestMethod.POST)
    @ResponseBody
    public int forageStoreAndInfoSave(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        int forageInfoStatus=forageInfomationService.forageInfomationAdd(request);
        int forageStoreStatus=forageStoreService.forageStoreSave(request);
        if(forageInfoStatus==0&&forageStoreStatus==0)
            return 0;//成功
        else
            return 1;//失败
    }

    //饲料储量删除
    @RequestMapping(value = "/forageStoreDelete",method = RequestMethod.POST)
    @ResponseBody
    public int forageStoreDelete(HttpServletRequest request,HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        return forageStoreService.forageStoreDelete(request);
    }

    //饲料储量查询
    @RequestMapping(value = "/forageStoreGet",method = RequestMethod.GET)
    @ResponseBody
    public List<ForageStoreEntity> forageStoreGet(HttpServletResponse response){
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        return forageStoreService.forageStoreGet();
    }

    //饲料出入库信息删除
    @RequestMapping(value = "/forageInfomationDelete",method = RequestMethod.POST)
    @ResponseBody
    public int forageInfomationDelete(HttpServletRequest request,HttpServletResponse response){
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        return forageInfomationService.forageInfomationDelete(request);
    }

    //饲料出入库信息查询
    @RequestMapping(value = "/forageInfomationGet",method = RequestMethod.GET)
    @ResponseBody
    public List<ForageInfomationEntity> forageInfomationGet(HttpServletResponse response){
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        return forageInfomationService.forageInfomationGet();
    }

    //饲料出库信息（饲料发放）增加
    @RequestMapping(value = "/forageProvideInfo",method = RequestMethod.GET)
    @ResponseBody
    public int forageProvideInfo(HttpServletRequest request,HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        forageInfomationService.forageProvideInfo(request);
        return 0;
    }
}
