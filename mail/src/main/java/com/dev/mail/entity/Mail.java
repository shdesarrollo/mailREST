package com.dev.mail.entity;

import org.springframework.web.multipart.MultipartFile;

public class Mail {

	private String username;
    private String to;
    private String subject;
    private String text;
    private MultipartFile file;
    private String message;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Mail(){}

	public Mail(String username, String to, String subject, String text, MultipartFile file, String message) {
		super();
		this.username = username;
		this.to = to;
		this.subject = subject;
		this.text = text;
		this.file = file;
		this.message = message;
	}
	
}
