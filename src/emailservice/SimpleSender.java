/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emailservice;


import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



/**
 *
 * @author baochenhu
 */
public class SimpleSender {
    
//  public static void Email(String args0,String args1,String args2,String args3,String args4)
//    {
//    try
//     {
//      String smtpServer=args0;
//      String to=args1;
//      String from=args2;
//      String subject=args3;
//      String body=args4;
//      send(smtpServer,to,from,subject,body);
//     }
//    catch (Exception ex)
//    {
//      System.out.println("Usage: java com.lotontech.mail.SimpleSender"
//       +" smtpServer toAddress fromAddress subjectText bodyText");
//    }
//    System.exit(0);
//   }
//   public static void send(String smtpServer, String to, String from
//   , String subject, String body)
//    {
//    try
//    {
//      Properties props = System.getProperties();
//      // -- Attaching to default Session, or we could start a new one --
//      props.put("mail.smtp.host", smtpServer);
//      Session session = Session.getDefaultInstance(props, null);
//      // -- Create a new message --
//      Message msg = new MimeMessage(session);
//      // -- Set the FROM and TO fields --
//      msg.setFrom(new InternetAddress(from));
//      msg.setRecipients(Message.RecipientType.TO,
//        InternetAddress.parse(to, false));
//      // -- We could include CC recipients too --
//      // if (cc != null)
//      // msg.setRecipients(Message.RecipientType.CC
//      // ,InternetAddress.parse(cc, false));
//      // -- Set the subject and body text --
//      msg.setSubject(subject);
//      msg.setText(body);
//      // -- Set some other header information --
//      msg.setHeader("X-Mailer", "LOTONtechEmail");
//      msg.setSentDate(new Date());
//      // -- Send the message --
//      Transport.send(msg);
//      System.out.println("Message sent OK.");
//    }
//    catch (Exception ex)
//    {
//      ex.printStackTrace();
//    }
//  }
    public  void Send(String to,String From,String subject,String body) {
 
		final String username = "baochenhu@gmail.com";
		final String password = "hubaochen123456";
 
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
 
		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
                        
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });
 
		try {
 
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(From));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(to));
			message.setSubject(subject);
			message.setText(body);
 
			Transport.send(message);
 
			System.out.println("Done");
 
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}

