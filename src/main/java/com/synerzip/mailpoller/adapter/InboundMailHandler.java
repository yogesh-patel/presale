package com.synerzip.mailpoller.adapter;

import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.springframework.messaging.Message;

public class InboundMailHandler {
	private static Logger logger = Logger.getLogger(InboundMailHandler.class);

	public void onNewMail(Message<?> message) {
		logger.info("Message: " + message);
		Object payload = message.getPayload();
		if (payload instanceof MimeMessage) {
			MimeMessage mailMessage = (MimeMessage) payload;
			try {
				System.out.println(mailMessage.getSubject());
				System.out.println(mailMessage.getSender());
				System.out.println(mailMessage.getReplyTo());
			} catch (Throwable t) {

			}
		}
	}
}
