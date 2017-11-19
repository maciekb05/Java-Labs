import java.util.*;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Sending {
    static void sendEmail(EmailMessage email){
//        Scanner in = new Scanner(System.in);
//        String emailPass;
//        System.out.println("Podaj hasło: ");
//        emailPass = in.nextLine();
        final String username = email.getFrom();
        final String password = "mojehaslo123";//emailPass;

        Properties props = new Properties();
        //Google:
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");
        //Microsoft:
//            props.setProperty("mail.transport.protocol", "smtp");
//            props.setProperty("mail.host", "smtp.live.com");
//            props.put("mail.smtp.starttls.enable", "true");
//            props.put("mail.smtp.auth", "true");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

            try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(email.getFrom()));
            if(email.getTo() != null) {
                for (String to : email.getTo()) {
                    if (!to.equals(""))
                        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
                }
            }
            if(email.getCc() != null) {
                for (String cc : email.getCc()) {
                    if (!cc.equals(""))
                        message.addRecipient(Message.RecipientType.CC, new InternetAddress(cc));
                }
            }
            if(email.getBcc() != null)
            {
                for(String bcc : email.getBcc()){
                    if(!bcc.equals(""))
                        message.addRecipient(Message.RecipientType.BCC, new InternetAddress(bcc));
                }
            }

            message.setSubject(email.getSubject());
            if(email.getMimeType()!=null){
                message.setContent(email.getContent(), email.getMimeType());
            }
            else{
                message.setText(email.getContent());
            }

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}