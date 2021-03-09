package com.mail;


import com.mail.dto.MailDTO;
import org.junit.Assert;
import org.junit.Test;

public class MailManagerTest {

    @Test
    public void submit() {
        MailManager mailManager = new MailManager();
        MailDTO mailDTO = new MailDTO();
        mailDTO.setEmail("Adrian.Dumke@web.de");
        mailDTO.setSubject("Test");
        mailDTO.setName("Adrian Dumke");
        mailDTO.setCopyWished(false);
        mailDTO.setMessage("das ist ein test");
        mailManager.submit(mailDTO);
    }

}