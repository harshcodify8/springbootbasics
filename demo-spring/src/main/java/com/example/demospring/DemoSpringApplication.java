package com.example.demospring;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoSpringApplication {

	private static Logger logger =  LoggerFactory.getLogger(DemoSpringApplication.class);
	//OtherClass.getClass()
	// giving wrong class path

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringApplication.class, args);
//		DemoSpringApplication.logger.info("my application has started");
		logger.info("my application has started");
		OtherClassImpl otherClass = new OtherClassImpl();
		otherClass.add(2,3);


//		 DemoSpringApplication d = new DemoSpringApplication();
//		 d.getClass();
//		 DemoSpringApplication.class;
//		 getClass() method returns the runtime class of an object.

        /*
		Logs done the chane (severity)
		Error
		Warn
		Info
		Debug
		Trace
	 */

		/*

		DemoController demoController = new DemoController(); // not be stored in the container.
		logger.info("DemoController object is {}",demoController);
		System.out.println(demoController);

		 */

		//DemoController object is com.example.demospring.DemoController@63c12e52
		//Creating object...com.example.demospring.DemoController@23f72d88
		// we can reuse that object what spring created,but we can create many objects with new but it would all over headache.

		// @component - > has many child annotations like service repo controller configuration
		// only controller is special because You can't write anything in replace of it because dispatcher servlet would not be able to recognize the controller and pass the api to the controller.



	}

}
