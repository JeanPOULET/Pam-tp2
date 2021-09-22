package pam.tp1.alert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import pam.tp1.format.SimpleFormatMessage;

import java.util.Arrays;

@Service
public class AlertMail implements IAlertMessenger {

    @Autowired
    public JavaMailSender emailSender;

    @Autowired
    private SimpleFormatMessage simpleFormatMessage;


    @Override
    public void sendMessage(String message) {


        String[] msgs = simpleFormatMessage.parseResponse(message);

        System.out.println(Arrays.toString(msgs));


        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(simpleFormatMessage.removeWhiteSpace(msgs[0]));
        mail.setSubject(msgs[1]);
        mail.setText(msgs[2]);
        emailSender.send(mail);

    }

}
