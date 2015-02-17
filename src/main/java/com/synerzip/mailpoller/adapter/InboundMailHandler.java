package com.synerzip.mailpoller.adapter;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.mail.Address;
import javax.mail.Multipart;
import javax.mail.internet.MimeBodyPart;
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
				StringBuffer contentStrBuffer = null;
				String subject = mailMessage.getSubject();
				String emailFrom = mailMessage.getFrom()[0].toString();
				Address[] recipients = mailMessage.getAllRecipients();
				StringBuffer recipientStrBuffer = new StringBuffer();
				String companyURL = "";
				if (recipients != null) {
					for (Address address : recipients) {
						recipientStrBuffer.append(address.toString());
						recipientStrBuffer.append("|");
					}
				}
				Object content = mailMessage.getContent();
				if (mailMessage.getContentType().contains("multipart")) {
					if (content instanceof Multipart) {
						Multipart multiPart = (Multipart) content;
						for (int i = 0; i < multiPart.getCount(); i++) {
							MimeBodyPart part = (MimeBodyPart) multiPart
									.getBodyPart(i);
							if (part.getContentType().contains("text/plain")) {
								contentStrBuffer = new StringBuffer();
								BufferedReader br = new BufferedReader(
										new InputStreamReader(
												part.getInputStream()));
								String line = null;
								while ((line = br.readLine()) != null) {
									if ((line.startsWith("On") && line
											.endsWith(">"))
											|| (line.contains("Forwarded message"))) {
										break;
									}
									contentStrBuffer.append(line);
								}
							} else if (part.getContentType().contains(
									"text/html")) {
								contentStrBuffer = new StringBuffer();
								BufferedReader br = new BufferedReader(
										new InputStreamReader(
												part.getInputStream()));
								String line = null;
								while ((line = br.readLine()) != null) {
									if (line.contains("href")) {

										for (int index = line
												.indexOf("href=\"") + 6; index < line
												.length(); index++) {
											companyURL += line.charAt(index);
											if (companyURL.lastIndexOf("com") != -1
													|| companyURL
															.lastIndexOf("net") != -1
													|| companyURL
															.lastIndexOf("org") != -1) {
												break;
											}
										}
									}
								}
							}
						}

					}
				}
				if(subject.contains("Re:")){
					//There should be entry for this prospects in DB, 
				}
				subject = subject.replaceAll("Re:", "").trim();
				subject = subject.replaceAll("Fwd:", "").trim();

				// Remove word like Oppty , opportunity , prospect
				subject = subject.replaceAll("Oppty", "").trim();
				subject = subject.replaceAll("opportunity", "").trim();
				subject = subject.replaceAll("Opportunity", "").trim();
				subject = subject.replaceAll("prospect", "").trim();
				subject = subject.replaceAll("Prospect", "").trim();

				// If subject contains "-" or ":"
				String techStack = "";
				String prospectName = subject;
				if (subject.contains("-")) {
					String[] moreDesc = subject.split("-");
					if (moreDesc.length > 0) {
						prospectName = moreDesc[0].trim();
					}
					if (moreDesc.length > 1) {
						techStack = moreDesc[1].trim();
					}

				} else if (subject.contains(":")) {
					String[] moreDesc = subject.split(":");
					if (moreDesc.length > 0) {
						prospectName = moreDesc[0].trim();
					}
					if (moreDesc.length > 1) {
						techStack = moreDesc[1].trim();
					}

				}

				System.out.println(prospectName + "\n" + companyURL + "\n"
						+ techStack + "\n" + emailFrom + "\n"
						+ recipientStrBuffer + "\n" + contentStrBuffer);
			} catch (Throwable t) {

			}
		}
	}
}
