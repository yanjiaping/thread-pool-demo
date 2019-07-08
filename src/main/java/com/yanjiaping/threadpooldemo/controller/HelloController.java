package com.yanjiaping.threadpooldemo.controller;

import com.yanjiaping.threadpooldemo.service.IAsyncService;
import com.yanjiaping.threadpooldemo.serviceImpl.AsyncServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private static final Logger logger = LoggerFactory.getLogger(AsyncServiceImpl.class);

    @Autowired
    private IAsyncService iAsyncService;

    @RequestMapping("/")
    public String submit() {
        logger.info("start submit");

        //调用service层的任务
        iAsyncService.executeAsync();

        logger.info("end submit");

        return "success";
    }

}
