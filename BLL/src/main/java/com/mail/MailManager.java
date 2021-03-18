package com.mail;

import com.mail.dto.MailDTO;
import com.mail.interfaces.IMailManager;
import com.security.PasswordUtils;

import javax.enterprise.context.RequestScoped;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

@RequestScoped
public class MailManager implements IMailManager {

    public boolean submit(final MailDTO mailDTO){

        final String username = "adrian@dumke.local";
        final String password = "Rayquaza123";
        Properties prop = new Properties();
        try(InputStream inputStream = this.getClass().getResourceAsStream("/mail.properties")) {
            prop.load(inputStream);
        } catch (IOException e){
            return false;
        }

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("halloWelt@gmail.de","Adrian Dumke"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("Adrian.Dumke@web.de")
            );
            message.setSubject(mailDTO.getSubject());
            message.setText(mailDTO.getMessage());
            Transport.send(message);
            return true;

        } catch (MessagingException | UnsupportedEncodingException e) {
            return false;
        }
    }
}
