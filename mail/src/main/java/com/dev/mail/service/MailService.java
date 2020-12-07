package com.dev.mail.service;

import com.dev.mail.entity.Mail;

public interface MailService {

	Mail sendMail(Mail mail);
	Mail sendMailWithFile(Mail mail);
	
}



