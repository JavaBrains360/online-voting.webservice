package com.javabrains.project.Online.voting.system.service;

import com.javabrains.project.Online.voting.system.model.Voter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendMail(Voter voter){
        SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
        simpleMailMessage.setTo(voter.getEmail());
        simpleMailMessage.setSubject("Online voting : Registration successfull");
        simpleMailMessage.setText("Hi "+ voter.getFirstname() +"\n Your registration on voting portal is successfully");

        log.info("sending mail to {}"+voter.getEmail());
        javaMailSender.send(simpleMailMessage);
    }
}
