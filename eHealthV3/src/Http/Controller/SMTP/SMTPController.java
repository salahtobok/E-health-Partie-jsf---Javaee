package Http.Controller.SMTP;

import javax.ejb.Singleton;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 * Created by salahtobok on 17-05-2017.
 */


@Singleton
public class SMTPController {
    private String message;
    private String emailContentType;

    private String securityStandard;

    //shared
    private String user_name;
    private String pass_word;
    private String mail_smtp_host;
    private String mail_smtp_auth;
    private String mail_smtp_portSSL;
    private String mail_smtp_portTLS;
    private String sender_mail;
    private String receiver_mail;
    private String emailSubject;
    private String emailContent;
    //ssl
    private String mail_smtp_socketFactory_port;
    private String mail_smtp_socketFactory_class;

    //tls
    private String mail_smtp_starttls_enable;


    public SMTPController() {
        //shared
        this.user_name = "ehealthprojectdz@gmail.com";
        this.pass_word = "aE[P53Sa9Ms/Gy{&";
        this.mail_smtp_host = "smtp.gmail.com";
        this.mail_smtp_auth = "true";
        this.mail_smtp_portSSL = "465";
        this.mail_smtp_portTLS = "587";
        this.sender_mail = "ehealthprojectdz@gmail.com";
        this.receiver_mail = "s.tobok@esi-sba.dz";
        this.emailSubject = "gzegez";
        this.emailContent = "vzvez";
        //ssl
        this.mail_smtp_socketFactory_port = "465";
        this.mail_smtp_socketFactory_class = "javax.net.ssl.SSLSocketFactory";

        //tls
        this.mail_smtp_starttls_enable = "true";

        this.emailContentType = "html";

        this.securityStandard = "ssl";

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getEmailContentType() {
        return emailContentType;
    }

    public void setEmailContentType(String emailContentType) {
        this.emailContentType = emailContentType;
    }

    public String getEmailSubject() {
        return emailSubject;
    }

    public void setEmailSubject(String emailSubject) {
        this.emailSubject = emailSubject;
    }


    public String getEmailContent() {
        return emailContent;
    }

    public void setEmailContent(String emailContent) {

        this.emailContent = emailContent;
    }

    public String getSecurityStandard() {
        return securityStandard;
    }

    public void setSecurityStandard(String securityStandard) {
        this.securityStandard = securityStandard;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPass_word() {
        return pass_word;
    }

    public void setPass_word(String pass_word) {
        this.pass_word = pass_word;
    }

    public String getMail_smtp_host() {
        return mail_smtp_host;
    }

    public void setMail_smtp_host(String mail_smtp_host) {
        this.mail_smtp_host = mail_smtp_host;
    }

    public String getMail_smtp_auth() {
        return mail_smtp_auth;
    }

    public void setMail_smtp_auth(String mail_smtp_auth) {
        this.mail_smtp_auth = mail_smtp_auth;
    }

    public String getMail_smtp_portSSL() {
        return mail_smtp_portSSL;
    }

    public void setMail_smtp_portSSL(String mail_smtp_portSSL) {
        this.mail_smtp_portSSL = mail_smtp_portSSL;
    }

    public String getMail_smtp_portTLS() {
        return mail_smtp_portTLS;
    }

    public void setMail_smtp_portTLS(String mail_smtp_portTLS) {
        this.mail_smtp_portTLS = mail_smtp_portTLS;
    }

    public String getSender_mail() {
        return sender_mail;
    }

    public void setSender_mail(String sender_mail) {
        this.sender_mail = sender_mail;
    }

    public String getReceiver_mail() {
        return receiver_mail;
    }

    public void setReceiver_mail(String receiver_mail) {
        this.receiver_mail = receiver_mail;
    }

    public String getMail_smtp_socketFactory_port() {
        return mail_smtp_socketFactory_port;
    }

    public void setMail_smtp_socketFactory_port(String mail_smtp_socketFactory_port) {
        this.mail_smtp_socketFactory_port = mail_smtp_socketFactory_port;
    }

    public String getMail_smtp_socketFactory_class() {
        return mail_smtp_socketFactory_class;
    }

    public void setMail_smtp_socketFactory_class(String mail_smtp_socketFactory_class) {
        this.mail_smtp_socketFactory_class = mail_smtp_socketFactory_class;
    }

    public String getMail_smtp_starttls_enable() {
        return mail_smtp_starttls_enable;
    }

    public void setMail_smtp_starttls_enable(String mail_smtp_starttls_enable) {
        this.mail_smtp_starttls_enable = mail_smtp_starttls_enable;
    }




    public boolean send() {

        return SendMailTLS.SendMailTLS_Simple(user_name,pass_word,mail_smtp_host,mail_smtp_auth,mail_smtp_starttls_enable,mail_smtp_portTLS,sender_mail,receiver_mail,emailSubject,emailContent);

}}

