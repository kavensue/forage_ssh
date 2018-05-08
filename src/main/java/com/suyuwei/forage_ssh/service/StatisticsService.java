package com.suyuwei.forage_ssh.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.suyuwei.forage_ssh.dao.FeederProblemJPA;
import com.suyuwei.forage_ssh.dao.ForageInfomationJPA;
import com.suyuwei.forage_ssh.entity.ForageInfomationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@Service
public class StatisticsService {
    @Autowired
    private ForageInfomationJPA forageInfomationJPA;
    @Autowired
    private FeederProblemJPA feederProblemJPA;

    //统计最近五个月的饲料入库总量
    public String forageStatisticsIn(HttpServletRequest request){
        String forageType=request.getParameter("forageType");
        String adminName=request.getParameter("adminName");

        List<Long> forageInfomationEntityList=forageInfomationJPA.findByTypeAndNameIn(forageType,adminName);
        JSONObject jsonStatistics=new JSONObject();
        for(int i=0;i<forageInfomationEntityList.size();i++){
            jsonStatistics.put(String.valueOf(i+1),forageInfomationEntityList.get(i));
        }
        return jsonStatistics.toString();
    }

    //统计最近五个月的问题反馈数量
    public String problemStatistics(HttpServletRequest request){
        String s=request.getParameter("months");
        Long months=Long.valueOf(request.getParameter("months"));
        List<Long> problemStatistics=feederProblemJPA.findCountProblem(months);
        JSONObject jsonStatistics=new JSONObject();
        for (int i=0;i<problemStatistics.size();i++){
            jsonStatistics.put(String.valueOf(i+1),problemStatistics.get(i));
        }
        return jsonStatistics.toString();
    }

    public void test(){
        String forageType="大猪料";
        String adminName="admin";
        List<Long> forageInfomationEntityList=forageInfomationJPA.findByTypeAndNameIn(forageType,adminName);
        System.out.println(forageInfomationEntityList.toString());
    }
}
