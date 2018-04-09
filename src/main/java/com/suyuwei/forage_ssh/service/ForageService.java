package com.suyuwei.forage_ssh.service;

import com.suyuwei.forage_ssh.dao.ForageGainJPA;
import com.suyuwei.forage_ssh.entity.ForageGainEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class ForageService {
    @Autowired
    private ForageGainJPA forageGainJPA;

    public void ForageGainSave(HttpServletRequest request){
        int forageRoomNum=Integer.parseInt(request.getParameter("forageRoom"));
        HttpSession session=request.getSession(false);
        String userName = (String) session.getAttribute("username");
        Long userId = (Long) session.getAttribute("userid");
        Date day=new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        ForageGainEntity forageGainEntity=new ForageGainEntity();
        switch(forageRoomNum){
            case 1:{
                forageGainEntity.setFeederId(userId);
                forageGainEntity.setFeederName(userName);
                forageGainEntity.setForageGainPlace("1号饲料室");
                forageGainEntity.setForageGainTime(sdf.format(day));
                break;
            }
            case 2:{
                forageGainEntity.setFeederId(userId);
                forageGainEntity.setFeederName(userName);
                forageGainEntity.setForageGainPlace("2号饲料室");
                forageGainEntity.setForageGainTime(sdf.format(day));
                break;
            }

        }
        forageGainJPA.save(forageGainEntity);
    }
}
