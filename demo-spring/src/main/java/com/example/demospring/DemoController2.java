package com.example.demospring;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v2")
public class DemoController2 {

    @Autowired
    Demo demo;

    // shared singleton(because they would be same Demo object as DemoController)
    private static Logger logger = LoggerFactory.getLogger(DemoController2.class);

    @GetMapping("/sample")
    public Demo getDemo(){
        logger.info("demo object in sample API - {}", demo);
        return demo;
    }

    /*
    If I would know invoke v2 api , I would see it's object after
    specifying as prototype
     */

}
