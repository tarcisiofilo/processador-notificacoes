package com.sica.service;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import com.sica.service.dto.NotificacaoSmsWhatsappDTO;

@RabbitListener(queues = "notificacaoSmsWhatsappQueue")
public class NotificacaoSmsWhatsappReceiver {

	@RabbitHandler
	public void receive(NotificacaoSmsWhatsappDTO notificacaoSmsWhatsapp) {
		System.out.println(" [x] Received '" + notificacaoSmsWhatsapp.getTo() + "'");
	}

}