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
         //�������ʼ��Ự
         Session session = Session.getInstance(props);
         //������Ϣ��
         MimeMessage message = new MimeMessage(session);
         //������ַ
         Address address = new InternetAddress("XXXX@qq.com");
         message.setFrom(address);
         //�ռ���ַ
         Address toAddress = new InternetAddress("XXXX@qq.com");
         message.setRecipient(MimeMessage.RecipientType.TO, toAddress);
         //����
         message.setSubject("Hello world");
         //����
         message.setText("Hello world");
         message.saveChanges();
         session.setDebug(true);
         Transport transport = session.getTransport("smtp");
         transport.connect("smtp.qq.com", "XXXX@qq.com", "password");
         //����
         transport.sendMessage(message, message.getAllRecipients());
         transport.close();

     }
 }
