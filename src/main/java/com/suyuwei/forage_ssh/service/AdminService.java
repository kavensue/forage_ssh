package com.suyuwei.forage_ssh.service;

import com.suyuwei.forage_ssh.dao.AdminJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    private AdminJPA adminJPA;


}
