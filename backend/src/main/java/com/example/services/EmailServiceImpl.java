package com.example.services;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService{
	
	
	@Autowired
	private JavaMailSender mailsender;
	
	private Logger logger =LoggerFactory.getLogger(EmailServiceImpl.class);
	
	@Override
	public void sendEmail(String to, String subject, String message) {
		
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setTo(to);
		simpleMailMessage.setSubject(subject);
		simpleMailMessage.setText(message);
		simpleMailMessage.setFrom("ikhekre@gmail.com");
		
		mailsender.send(simpleMailMessage);
		logger.info("Email has been send ..............");
		
	}

}
