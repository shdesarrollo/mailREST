package com.dev.mail.service.impl;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.dev.mail.entity.Mail;
import com.dev.mail.service.MailService;

@Service
public class MailServiceImpl implements MailService {
	
	private static final Logger log = LoggerFactory.getLogger(MailServiceImpl.class);
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Value("${spring.mail.username}")
	private String from;
	
	@Autowired
    public MailServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }
	
	@Override
	public Mail sendMail(Mail mail) {
		SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setSubject(mail.getSubject());
        message.setText(mail.getText());
        message.setTo(mail.getTo());
        
        try {
            javaMailSender.send(message);
        } catch (Exception e) {
            mail.setMessage(e.getMessage());
            log.error("failed to send mail[{}],{}", mail, e.getMessage());
        }
        return mail;
	}
	
	@Override
	public Mail sendMailWithFile(Mail mail) {
		MimeMessage message = javaMailSender.createMimeMessage();
		
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(mail.getTo());
            helper.setSubject(mail.getSubject());
            helper.setText(mail.getText(), true);
            FileSystemResource file = new FileSystemResource(mail.getFile().toString());
            helper.addAttachment(mail.getFile().getName(), file);

            javaMailSender.send(message);
            log.info("!Correo enviado con exito");
        } catch (MessagingException e) {
            log.error("!Error al enviar el correo", e);
        }
        return mail;
	}
	
	
	
}
