package pam.tp1.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pam.tp1.alert.AlertMail;
import pam.tp1.format.IFormatMessage;

//@SpringBootApplication 
@Configuration
//@EnableAutoConfiguration
public class HelloWorld {
    
    public static void main(String[] args) throws Exception {
    		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:spring/application-config.xml");
	
    		SpringApplication.run(HelloWorld.class, args);
    		
    		String initialMessage= "xxxxbonjour\t\t   le     monde\n truc bidull eeee      eeee";
    		System.out.println(initialMessage);
    		
    		
    		//Question 1
    		IFormatMessage formater = (IFormatMessage) context.getBean("simple_message_formater");
    		System.out.println(formater.formatMessage(initialMessage));
    	        
    		IFormatMessage formater2 = (IFormatMessage) context.getBean("advanced_message_formater");
    		//System.out.println(formater2.formatMessage(initialMessage));
    		
    		//Question 2
    		AlertMail alertMail = (AlertMail) context.getBean("alertMail");
    		alertMail.sendMessage(formater2.formatMessage(initialMessage));
    		
    }
}

