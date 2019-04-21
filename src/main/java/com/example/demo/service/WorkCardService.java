package com.example.demo.service;

import com.example.demo.mybatis.mapper.WorkCardMapper;
import com.example.demo.mybatis.po.WorkCard;
import com.sun.corba.se.spi.orbutil.threadpool.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkCardService {
    //注解注入WorkCardMapper
    @Autowired
    private WorkCardMapper workCardMapper;

    public WorkCard getWorkCard(Integer empId) {
        return this.workCardMapper.getWorkCard(empId);
    }

}
