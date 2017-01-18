/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taxigoresource;

import java.util.List;
import java.util.Properties;
import javax.ejb.Stateless;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Sara
 */
@Stateless
public class EmailSenderEJB {
    
    
    public void setRecipientsAndSendEmail(List <String> addresses, String title, String message) {
        List <String> sendTo = addresses;
        
        int size = sendTo.size();
        for (int i = 0; i < size; i++) {
            sendEmail(sendTo.get(i), title, message);
        }
    }
    
    
    public void sendEmail(String sendTo, String title, String message) {
        try {
            //This properties are valid for gmail.  You need to check for other mail providers/servers/agents.
            Properties props = new Properties();
            props.setProperty("mail.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.auth", "true");
            props.setProperty("mail.smtp.starttls.enable", "true");
            System.out.println("So far so good -1 setting up session parameters");

            //  Authentication is performed here.  
            MyAuth auth = new MyAuth("taxigo.project@gmail.com", "taxigo12345");
            System.out.println("So far so good-2 authenticator called....");

            //  The mail session is instantiated
            //  The rest is copied from Java Mail documentation.
            Session mailConnection = Session.getInstance(props, auth);
            Message msg = new MimeMessage(mailConnection);
            Address sender = new InternetAddress("taxigo.project@gmail.com", "TaxiGo");
            Address receiver = new InternetAddress(sendTo);
            Session session = Session.getInstance(props);
            msg.setContent(message, "text/plain");
            msg.setFrom(sender);
            msg.setRecipient(Message.RecipientType.TO, receiver);
            msg.setSubject(title);

            Transport transport = session.getTransport("smtp");
            transport.connect("taxigo.project@gmail.com", "taxigo12345");


            Transport.send(msg);
        } catch (MessagingException e) {
            System.out.printf("Messaging Exception: " + e.getMessage());
//          throw new RuntimeException(e);
        } catch (Exception ex) {
            System.out.printf("General Exception: ");
            ex.printStackTrace();
        }
        
    }
    
    private class MyAuth extends Authenticator {

        private PasswordAuthentication authentication;

        public MyAuth(String login, String password) {
            authentication = new PasswordAuthentication(login, password);
        }

        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
            return authentication;
        }
    }
}
