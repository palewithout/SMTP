package SMTP;

import java.util.Properties;
import javax.mail.Address;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SMTP {

     public static void main(String[] args) throws Exception {
         Properties props = new Properties();
         props.put("mail.smtp.host", "smtp.qq.com");
         props.put("mail.smtp.auth", "true");
         //基本的邮件会话
         Session session = Session.getInstance(props);
         //构造信息体
         MimeMessage message = new MimeMessage(session);
         //发件地址
         Address address = new InternetAddress("XXXX@qq.com");
         message.setFrom(address);
         //收件地址
         Address toAddress = new InternetAddress("XXXX@qq.com");
         message.setRecipient(MimeMessage.RecipientType.TO, toAddress);
         //主题
         message.setSubject("Hello world");
         //正文
         message.setText("Hello world");
         message.saveChanges();
         session.setDebug(true);
         Transport transport = session.getTransport("smtp");
         transport.connect("smtp.qq.com", "XXXX@qq.com", "password");
         //发送
         transport.sendMessage(message, message.getAllRecipients());
         transport.close();

     }
 }
