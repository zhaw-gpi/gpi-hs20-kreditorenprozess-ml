package ch.zhaw.gpi.benachrichtigungsservice;

import javax.annotation.PostConstruct;

import org.camunda.bpm.client.ExternalTaskClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SendMailExternalTaskClient {

    private ExternalTaskClient externalTaskClient;

    @Autowired
    private SendMailHandler sendMailHandler;

    @PostConstruct
    private void init() {

        externalTaskClient = ExternalTaskClient.create().baseUrl("http://localhost:8081/engine-rest")
                .workerId("benachrichtigungsservice").maxTasks(5).lockDuration(5000).build();

        
        externalTaskClient.subscribe("SendMail").handler(sendMailHandler).open();
    }
}
