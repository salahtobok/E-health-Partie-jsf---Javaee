package Http.Controller.SMTP; /**
 * Created by salahtobok on 16-05-2017.
 */

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendMailTLS {

    public static boolean SendMailTLS_Simple(String user_name, String pass_word, String mail_smtp_host
            , String mail_smtp_auth, String mail_smtp_starttls_enable, String mail_smtp_port, String sender_amail, String receiver_amail
            , String subject, String content) {

        //05
        //props.put("mail.smtp.port", "587");


        final String username = user_name;
        final String password = pass_word;

        Properties props = new Properties();
        //01
        props.put("mail.smtp.host", mail_smtp_host);
        //04
        props.put("mail.smtp.auth", mail_smtp_auth);
        //05
        props.put("mail.smtp.port", mail_smtp_port);

        props.put("mail.smtp.starttls.enable", mail_smtp_starttls_enable);

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(sender_amail));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(receiver_amail));
            message.setSubject(subject);
            message.setText(content);

            Transport.send(message);

            System.out.println("Done");
            return true;
        } catch (MessagingException e) {
            return false;
        }
    }


    public static boolean SendMailTLS_Html(String user_name, String pass_word, String mail_smtp_host
            , String mail_smtp_auth, String mail_smtp_starttls_enable, String mail_smtp_port, String sender_amail, String receiver_amail
            , String subject, String content) {

        final String username = user_name;
        final String password = pass_word;

        Properties props = new Properties();
        //01
        props.put("mail.smtp.host", mail_smtp_host);
        //04
        props.put("mail.smtp.auth", mail_smtp_auth);
        //05
        props.put("mail.smtp.port", mail_smtp_port);

        props.put("mail.smtp.starttls.enable", mail_smtp_starttls_enable);

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(sender_amail));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(receiver_amail));
            message.setSubject(subject);
            message.setContent(content, "text/html");

            Transport.send(message);

            System.out.println("Done");

            return true;

        } catch (MessagingException e) {


            return false;
        }
    }
}