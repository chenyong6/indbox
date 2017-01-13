package com.cy.core.mq.rpc;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;


@Component("alertService")
public class AlertServiceImpl implements AlertService {

	@Override
	public void sendMsg(String msg) {
		System.err.println(msg);
	}
/*  private JavaMailSender mailSender;  
  private String alertEmailAddress;*/
  
/*  public AlertServiceImpl(JavaMailSender mailSender, 
                          String alertEmailAddress) {
    this.mailSender = mailSender;
    this.alertEmailAddress = alertEmailAddress;
  }*/
      
/*  public void sendMsg(final String msg) {
    SimpleMailMessage message = new SimpleMailMessage();
    String spitterName = msg; 
    message.setFrom("noreply@spitter.com"); 
    message.setTo(alertEmailAddress); 
    message.setSubject("New spittle from " + spitterName);
    message.setText(spitterName + " says: " + msg);
    System.err.println(msg);
   // mailSender.send(message);
  }  */
}
