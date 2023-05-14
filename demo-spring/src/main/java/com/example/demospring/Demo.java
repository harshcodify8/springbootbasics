package com.example.demospring;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Component
@Scope("prototype")
/*
It will create an object when it is reffered by another class (In demand)
 */
/*
@Service
@Repository
@Configuration
 */
public class Demo {

    private static Logger logger = LoggerFactory.getLogger(Demo.class);

    public Demo(){
        logger.info("Creating demo object ...{}",this);
        // this will show one object is creating only once.
    }
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
