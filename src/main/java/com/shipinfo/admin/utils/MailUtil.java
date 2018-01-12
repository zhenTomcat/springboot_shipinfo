package com.shipinfo.admin.utils;



import com.shipinfo.admin.modules.sys.entity.MailAuthenticator;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.IOException;
import java.io.InputStream;
import java.security.Security;
import java.util.Properties;

/**
 * Created by lenovo on 2017/3/20.
 */
public class MailUtil {

    private static String sitePath;

    private static String fromAddress;

    private static String fromPassword;

    private static String mailSmtpHost;

    private static String mailSmtpPort;

    private static String effectiveTime;

    static {
        Properties prop = new Properties();
        InputStream in = MailUtil.class.getResourceAsStream("/application.yml");
        try {
            prop.load(in);
            sitePath = prop.getProperty("site_path");
            fromAddress = prop.getProperty("fromAddress");
            fromPassword = prop.getProperty("fromPassword");
            mailSmtpHost = prop.getProperty("mail.smtp.host");
            mailSmtpPort = prop.getProperty("mail.smtp.port");
            effectiveTime = prop.getProperty("effectiveTime");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //发送邮件 1.收件人 2.信息 3.标题 4.附件
    public static void sendEmail(String toAddress, String text, String subject, Multipart multipart) {
        Properties props = new Properties();
        Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
        final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
        props.put("mail.smtp.host", mailSmtpHost); //smtp服务器地址
        props.put("mail.smtp.socketFactory.class", SSL_FACTORY);
        props.put("mail.smtp.socketFactory.fallback", "false");
        props.put("mail.smtp.port", mailSmtpPort);
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.auth", true);  //是否需要认证
        MailAuthenticator myauth = new MailAuthenticator(fromAddress, fromPassword);
        //获得一个带有authenticator的session实例
        Session session = Session.getInstance(props, myauth);
        session.setDebug(true);//打开debug模式，会打印发送细节到console
        Message message = new MimeMessage(session); //实例化一个MimeMessage集成自abstract Message 。参数为session
        try {
            message.setFrom(new InternetAddress(fromAddress)); //设置发出方,使用setXXX设置单用户，使用addXXX添加InternetAddress[]
            if (text != null) {
                message.setContent(text, "text/html;charset=utf-8"); //设置文本内容 单一文本使用setText,Multipart复杂对象使用setContent
            }
            if (multipart != null) {
                message.setContent(multipart);
            }
            message.setSubject(subject); //设置标题
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(toAddress)); //设置接收方
            Transport.send(message); //使用Transport静态方法发送邮件
        } catch (AddressException e) {
            //此处处理AddressException异常  [The exception thrown when a wrongly formatted address is encountered.]
            e.printStackTrace();
        } catch (MessagingException e) {
            //此处处理MessagingException异常 [The base class for all exceptions thrown by the Messaging classes ]
            e.printStackTrace();
        }
    }

    //发送邮件 1.收件人 2.信息 3.标题 4.附件
    public static void sendEmail(String[] toAddress, String text, String subject, Multipart multipart) {
        Properties props = new Properties();
        Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
        final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
        props.put("mail.smtp.host", mailSmtpHost); //smtp服务器地址
        props.put("mail.smtp.socketFactory.class", SSL_FACTORY);
        props.put("mail.smtp.socketFactory.fallback", "false");
        props.put("mail.smtp.port", mailSmtpPort);
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.auth", true);  //是否需要认证

        MailAuthenticator myauth = new MailAuthenticator(fromAddress, fromPassword);
        //获得一个带有authenticator的session实例
        Session session = Session.getInstance(props, myauth);
        session.setDebug(true);//打开debug模式，会打印发送细节到console
        Message message = new MimeMessage(session); //实例化一个MimeMessage集成自abstract Message 。参数为session
        try {
            message.setFrom(new InternetAddress(fromAddress)); //设置发出方,使用setXXX设置单用户，使用addXXX添加InternetAddress[]
            if (text != null) {
                message.setContent(text, "text/html;charset=utf-8"); //设置文本内容 单一文本使用setText,Multipart复杂对象使用setContent
            }
            if (multipart != null) {
                message.setContent(multipart);
            }
            message.setSubject(subject); //设置标题
            InternetAddress[] addresses = new InternetAddress[toAddress.length];
            for (int i = 0; i < toAddress.length; i++) {
                addresses[i] = new InternetAddress(toAddress[i]);
            }
            message.addRecipients(Message.RecipientType.TO, addresses);
            Transport.send(message); //使用Transport静态方法发送邮件
        } catch (AddressException e) {
            //此处处理AddressException异常  [The exception thrown when a wrongly formatted address is encountered.]
        } catch (MessagingException e) {
            //此处处理MessagingException异常 [The base class for all exceptions thrown by the Messaging classes ]
        }
    }
}
