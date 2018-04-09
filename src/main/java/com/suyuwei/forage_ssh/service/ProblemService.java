package com.suyuwei.forage_ssh.service;

import com.suyuwei.forage_ssh.dao.FeederProblemJPA;
import com.suyuwei.forage_ssh.dao.ProblemJPA;
import com.suyuwei.forage_ssh.entity.FeederProblemEntity;
import com.suyuwei.forage_ssh.entity.ProblemEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ProblemService {
    @Autowired
    private ProblemJPA problemJPA;
    @Autowired
    private FeederProblemJPA feederProblemJPA;

    public List getProblem(){
        List<ProblemEntity> problemEntityList;
        problemEntityList=problemJPA.findAll();
        return problemEntityList;
    }

    public void ProblemSave(HttpServletRequest request){
        int problemNum=Integer.parseInt(request.getParameter("feedProblem"));
        HttpSession session=request.getSession(false);
        String userName = (String) session.getAttribute("username");
        Long userId = (Long) session.getAttribute("userid");
        String note=request.getParameter("note");
        Date day=new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        FeederProblemEntity feederProblemEntity=new FeederProblemEntity();
        switch(problemNum){
            case 1:{
                feederProblemEntity.setFeederId(userId);
                feederProblemEntity.setFeederName(userName);
                feederProblemEntity.setProblemPlace("1号饲料室");
                feederProblemEntity.setProblemType("饲料不足");
                feederProblemEntity.setFeederProblemRemark(note);
                feederProblemEntity.setFeederProblemTime(sdf.format(day));
                break;
            }
            case 2:{
                feederProblemEntity.setFeederId(userId);
                feederProblemEntity.setFeederName(userName);
                feederProblemEntity.setProblemPlace("1号饲料室");
                feederProblemEntity.setProblemType("饲料质量有问题");
                feederProblemEntity.setFeederProblemRemark(note);
                feederProblemEntity.setFeederProblemTime(sdf.format(day));
                break;
            }
            case 3:{
                feederProblemEntity.setFeederId(userId);
                feederProblemEntity.setFeederName(userName);
                feederProblemEntity.setProblemPlace("2号饲料室");
                feederProblemEntity.setProblemType("饲料不足");
                feederProblemEntity.setFeederProblemRemark(note);
                feederProblemEntity.setFeederProblemTime(sdf.format(day));
                break;
            }
            case 4:{
                feederProblemEntity.setFeederId(userId);
                feederProblemEntity.setFeederName(userName);
                feederProblemEntity.setProblemPlace("2号饲料室");
                feederProblemEntity.setProblemType("饲料质量有问题");
                feederProblemEntity.setFeederProblemRemark(note);
                feederProblemEntity.setFeederProblemTime(sdf.format(day));
                break;
            }
            case 5:{
                feederProblemEntity.setFeederId(userId);
                feederProblemEntity.setFeederName(userName);
                feederProblemEntity.setProblemPlace("1号猪舍");
                feederProblemEntity.setProblemType("猪食欲不振");
                feederProblemEntity.setFeederProblemRemark(note);
                feederProblemEntity.setFeederProblemTime(sdf.format(day));
                break;
            }
            case 6:{
                feederProblemEntity.setFeederId(userId);
                feederProblemEntity.setFeederName(userName);
                feederProblemEntity.setProblemPlace("1号猪舍");
                feederProblemEntity.setProblemType("猪感冒了");
                feederProblemEntity.setFeederProblemRemark(note);
                feederProblemEntity.setFeederProblemTime(sdf.format(day));
                break;
            }
            case 7:{
                feederProblemEntity.setFeederId(userId);
                feederProblemEntity.setFeederName(userName);
                feederProblemEntity.setProblemPlace("1号猪舍");
                feederProblemEntity.setProblemType("猪发烧了");
                feederProblemEntity.setFeederProblemRemark(note);
                feederProblemEntity.setFeederProblemTime(sdf.format(day));
                break;
            }
            case 8:{
                feederProblemEntity.setFeederId(userId);
                feederProblemEntity.setFeederName(userName);
                feederProblemEntity.setProblemPlace("2号猪舍");
                feederProblemEntity.setProblemType("猪食欲不振");
                feederProblemEntity.setFeederProblemRemark(note);
                feederProblemEntity.setFeederProblemTime(sdf.format(day));
                break;
            }
            case 9:{
                feederProblemEntity.setFeederId(userId);
                feederProblemEntity.setFeederName(userName);
                feederProblemEntity.setProblemPlace("2号猪舍");
                feederProblemEntity.setProblemType("猪感冒了");
                feederProblemEntity.setFeederProblemRemark(note);
                feederProblemEntity.setFeederProblemTime(sdf.format(day));
                break;
            }
            case 10:{
                feederProblemEntity.setFeederId(userId);
                feederProblemEntity.setFeederName(userName);
                feederProblemEntity.setProblemPlace("2号猪舍");
                feederProblemEntity.setProblemType("猪发烧了");
                feederProblemEntity.setFeederProblemRemark(note);
                feederProblemEntity.setFeederProblemTime(sdf.format(day));
                break;
            }

        }
        feederProblemJPA.save(feederProblemEntity);
    }
}
