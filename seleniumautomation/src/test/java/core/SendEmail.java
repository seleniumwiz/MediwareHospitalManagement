package core;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;


public class SendEmail extends commonLib {
	static int port;
	static String smtphostname;
	static String username,password,emailto;
/*
 * Author :Manu Mohan
 * 
 * For sending the Extent Report after the Execution.
 * 
 */

	public static void emailsend() throws EmailException {
		port = Data.SendEmail().get("PORT");
		smtphostname= Data.Emailcredentials().get("hostname");
		username=Data.Emailcredentials().get("username");
		password=Data.Emailcredentials().get("password");
		emailto=Data.Emailcredentials().get("emailto");

		MultiPartEmail email = new MultiPartEmail();
		email.setHostName(smtphostname);
		email.setSmtpPort(port);
		email.setAuthenticator(new DefaultAuthenticator(username,password));
		email.setSSLOnConnect(true);
		email.setFrom(username);
		email.setSubject("ExtentReport of Mediware");
		email.setMsg("extent report");
		email.addTo(emailto);

		EmailAttachment attachment = new EmailAttachment();
		attachment.setPath("E:\\Workspace\\STS\\seleniumautomation\\reports\\mediwareTestReport.html");
		attachment.setDisposition(EmailAttachment.ATTACHMENT);
		attachment.setDescription("ExtentReport of Mediware Automation");
		attachment.setName("ExtentReport");
		email.attach(attachment);
		email.send();
		System.out.println("-----------emailsend---------");

	}

}
