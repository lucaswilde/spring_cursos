package com.examplebr.com.alura.enviadorEmail.enviadorEmail;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
	public void enviarEmail(String nome, String emailConvidado) {
		try {
			System.out.println("nome: "+nome + " email: " + emailConvidado);
			Email email = new SimpleEmail();
			email.setHostName("smtp.googlemail.com");
			email.setSmtpPort(465);
			email.setAuthenticator(new DefaultAuthenticator("lucaswilde89@gmail.com", "senha+"));
			email.setSSLOnConnect(true);

			email.setFrom("lucaswilde89@gmail.com");
			email.setSubject("Você foi convidado pelo ListaVIP");
			email.setMsg("Olá " + nome + ". Você acaba de ser convidado pelo ListaVIP.");
			email.addTo(emailConvidado);
			email.send();
		} catch (EmailException e) {
			e.printStackTrace();
		}
	}
}
