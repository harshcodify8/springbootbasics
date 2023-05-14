package com.example.demospring;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


//@Controller
@RestController
// rest controller has response body which converts java to json, you would get 400 if you don't convert it into json , @Controller.
@RequestMapping("/v1")
//@Scope("prototype")
public class DemoController {

    // Bean - object which is created by spring earlier
    // Bean - Something which will create / know during the application startup.

   @Autowired
    Demo demo;
    /*
     Bean is just an object in spring context.
     @Autowired annotation picks the reference of class from the IOC CONTAINER.
     If we remove @component from Demo class and use it here,
     my application won't even start.
     */

    /* If I put @@Component in this class what would happen??
        when ever request comes, it is handled by dispatcher servlet.
        dispatcher servlet intercepts that and routes to a particular controller.
        dispatcher servlet code is written in your tomcat or jetty (Embedded server)
        dispatcher servlet does the url mapping, there it looks for Controller or RestController annotations.


        404 error will come.
        The 404 Not Found Error is an HTTP response status code, which indicates that the requested resource could not be found.

        The 404 error status code indicates that the REST API can't map the client's URI to a resource but may be available in the future.
        Subsequent requests by the client are permissible. No indication is given of whether the condition is temporary or permanent
     */

    private static Logger logger = LoggerFactory.getLogger(DemoController.class);


//    @Autowired
    /*
       use autowired if we want to create the other constructor to remove the problem below
     */
    public DemoController(Demo demo){
        this.demo=demo;
        logger.info("Creating object...{}",this);

    }

    /*

    @Value("${server.port}")
    private Integer a = 2;

    public DemoController(){
        logger.info("a= {}",a);
    }

    Easy -> @value happened after the bean of this is created. that why it is 2
           when it search for a, it would see it has a default value of 2.

           Moral of story is if you want to use value in api then go for above one otherwise,
           if you want to use it in constructor go for below one.
     */


    // this @Value happens after the bean of this is created.
    // but injection after the creation of bean


    /*
    public DemoController(@Value("${server.port}") int a){

    @value is similar like @autowired, value picks something like primitive type or wrapper classes.
        logger.info("a = {}",a);

        Parameter 0 of constructor in com....DemoController required a bean of type 'int' that could not be found.

        Spring would be in trouble which constructor to be used to create a bean(object) of RestController???

    }
     */


    /*
     Bean would be stored in IOC CONTAINER & when ever you need the reference.
     of the object it is taken from there and injected in the particular.
     Dependency Injection is only possible if there are some beans in container.

     */


    // some url , and you gave /sample an endpoint to invoke the below function.

    @GetMapping("/sample")
//    @ResponseBody
    public Demo getDemo(){

        /*
        Demo demo = new Demo();
         If we call it n times there would be n object.
         But we need to use the object that is created in the beginning.
         */

        logger.info("demo object in sample API - {}",demo);
        return demo;

    }

    /*

    Two was to inject dependency
    1. Constructor Injection
    2. Field Injection //@autowired
    3.

    How is doing java to json conversion?


            {
             "id" : 0,
             "name":null
            }
     */

    @PostMapping("/post_sample")
    public Demo postDemo(){

        logger.info("demo object in post-sample API - {}",demo);
        return demo;

    }
}
