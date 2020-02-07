package com.sica.service;

import java.io.IOException;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import com.sica.service.dto.NotificacaoEmailDTO;

@RabbitListener(queues = "notificacaoEmailQueue")
public class NotificacaoEmailReceiver {

	@RabbitHandler
	public void receive(NotificacaoEmailDTO notificacaoEmail) throws IOException {
		Email from = new Email("sica@test.com");
		String subject = "Registro de Incidente";
		Email to = new Email(notificacaoEmail.getTo());
		Content content = new Content("text/plain", notificacaoEmail.getMsg());
		Mail mail = new Mail(from, subject, to, content);
		SendGrid sg = new SendGrid("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");
		Request request = new Request();
		request.setMethod(Method.POST);
		request.setEndpoint("mail/send");
		request.setBody(mail.build());
		Response response = sg.api(request);
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody());
		System.out.println(response.getHeaders());
	}

}