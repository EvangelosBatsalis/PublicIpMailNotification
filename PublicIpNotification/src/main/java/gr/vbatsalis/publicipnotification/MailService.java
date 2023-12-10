package gr.vbatsalis.publicipnotification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {
    private JavaMailSender javaMailSender;

    @Autowired
    public MailService(JavaMailSender javaMailSender){
        this.javaMailSender=javaMailSender;
    }
    public void sentTextEmail(String ip){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("v.batsalis@gmail.com");
        simpleMailMessage.setTo("zyled@hotmail.com");
        simpleMailMessage.setSubject("ip Changed");
        simpleMailMessage.setText("ip is: "+ip);
        javaMailSender.send(simpleMailMessage);
    }

}
