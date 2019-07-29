package com.revature.mail;

import java.util.*;  
import javax.mail.*;  
import javax.mail.internet.*;  
import javax.activation.*; 


public class SendEmail {
	
	private String to;
	private String host;
	private String user;
	private String password;
	private String header;
	private String text;
	private String messageType;
	
	public SendEmail(String to, String fPassword, String messageType){
		this.to = to;
		if(messageType != null) {
			header = "Recall alert";
			text = "A vehicle you have shown interest in has been recalled!";
		}
		else {
			header = "Recover Password";
			text = "The password associated with this email is " + fPassword;
		}
		this.host = "smtp.gmail.com"; //using google mail service
		final String user = "rev.project2.javamail@gmail.com"; //project2 dummy email username
		final String password = "Q>^$yG^RE!4KVX:."; //dummy password
		
		//Get the session object  
		 	Properties prop = new Properties();
			prop.put("mail.smtp.host", "smtp.gmail.com");
	        prop.put("mail.smtp.port", "587");
	        prop.put("mail.smtp.auth", "true");
	        prop.put("mail.smtp.starttls.enable", "true"); //TLS  
		     
		   Session session = Session.getDefaultInstance(prop,  
		    new javax.mail.Authenticator() {  
			   protected PasswordAuthentication getPasswordAuthentication() {  
				   return new PasswordAuthentication(user,password);  
			   }  
		    });  
		  
		   //Compose the message  
		    try {  
			     MimeMessage message = new MimeMessage(session);  
			     message.setFrom(new InternetAddress(user));  
			     message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
			     message.setSubject(header);  
			     message.setText(text);  
			    //send the message  
			     Transport.send(message);  
			  
			     System.out.println("message sent successfully...");  
		   
		     } catch (MessagingException e) {e.printStackTrace();}  
		}
	    
		
}