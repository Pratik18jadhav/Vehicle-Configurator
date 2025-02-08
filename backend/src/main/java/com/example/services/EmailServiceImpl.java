package com.example.services;



import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

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

	@Override
	public void registeredEmail(String to, String user , String username) {
		MimeMessage mimeMessage = mailsender.createMimeMessage();
		
		try {
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true,"UTF-8");
			helper.setTo(to);
			
			helper.setSubject("Welcome to VConfig! Your Registration is Complete 🎉");
			helper.setFrom("ikhekre@gmail.com");
			
			String htmlContent =Files.readString(Paths.get("src/main/resources/registeredEmail.html"));
			
			htmlContent = htmlContent.replace("[User's Name]", user)
                    .replace("[User's Email]", to)
                    .replace("[User's Username]", username);

			htmlContent = htmlContent.replace("[User's Name]", user);
	       
			helper.setText(htmlContent,true);
			
			mailsender.send(mimeMessage);
			logger.info("Registered Email has been send ..............");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void invoiceEmail(String to, String compName,String invoiceNumber,double Amount, File file) {
		MimeMessage mimemessage = mailsender.createMimeMessage();
		
		try {
			MimeMessageHelper helper = new MimeMessageHelper(mimemessage,true,"UTF-8");
			helper.setFrom("ikhekre@gmail.com");
			helper.setTo(to);
			
			String sub="🧾 Thank You for Your Purchase! Here’s Your Invoice (["+invoiceNumber+"])";
			helper.setSubject(sub);
			
			String htmlContent =Files.readString(Paths.get("src/main/resources/invoiceEmail.html"));
			
			htmlContent = htmlContent.replace("[User's Name]", compName)
                    .replace("[Invoice Number]", invoiceNumber)
                    .replace("[Total Amount]", String.valueOf(Amount));
			
			helper.setText(htmlContent,true);
			
			FileSystemResource filesystemmresource = new FileSystemResource(file);
			helper.addAttachment(filesystemmresource.getFilename(), file);
			
			mailsender.send(mimemessage);
			
			logger.info("Invoice Email has been send ..............");
			
		} catch (MessagingException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
