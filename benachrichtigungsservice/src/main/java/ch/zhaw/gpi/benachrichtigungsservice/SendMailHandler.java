package ch.zhaw.gpi.benachrichtigungsservice;

import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class SendMailHandler implements ExternalTaskHandler {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${mail.overrideAddress}")
    private String overrideAddress;

    @Value("${spring.mail.username}")
    private String username;

    @Override
    public void execute(ExternalTask externalTask, ExternalTaskService externalTaskService) {
        Boolean materialCheckResult = (Boolean) externalTask.getVariable("materialCheckResult");
        Long referenceNr = (Long) externalTask.getVariable("referenceNr");
        String materialCheckComments = (String) externalTask.getVariable("materialCheckComments");

        String to = "kreditorenbuchhaltung@firma.ch";

        if (!overrideAddress.isEmpty()) {
            to = overrideAddress;
        }

        String subject;
        String body;

        if(materialCheckResult){
            subject = "Rechnung freigegeben: ";
            body = "Die Rechnung wurde im ERP zur Zahlung vorgemerkt.";
        } else {
            subject = "Rechnung abgelehnt: ";
            body = "Die Rechnung wurde materiell abgelehnt mit der Begründung: " + materialCheckComments;
        }

        subject += referenceNr.toString();

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        
        mailMessage.setFrom(username);
        mailMessage.setReplyTo(to);
        mailMessage.setTo(to);
        mailMessage.setSubject(subject);
        mailMessage.setText(body);
        
        try {
            javaMailSender.send(mailMessage);
            externalTaskService.complete(externalTask);
        } catch (Exception e) {
            externalTaskService.handleFailure(externalTask, "Mail-Versand fehlgeschlagen", e.getLocalizedMessage(), 0, 1);
        }
    }

}
