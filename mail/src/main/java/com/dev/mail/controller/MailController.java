package com.dev.mail.controller;

import javax.annotation.Resource;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.mail.common.Result;
import com.dev.mail.entity.Mail;
import com.dev.mail.service.MailService;

@RestController
@RequestMapping(value = "/mails", consumes = {"multipart/form-data"})
public class MailController {

	@Resource
	private MailService mailService;
	
	@PostMapping("/mail")
	public Result sendMail(@Validated Mail mail) throws Exception {
		mailService.sendMail(mail);
        return new Result();
	}
	
	@PostMapping("/mailFile")
	public Result sendMailWithFile(@Validated Mail mail) throws Exception {
		mailService.sendMail(mail);
        return new Result();
	}
	
}
