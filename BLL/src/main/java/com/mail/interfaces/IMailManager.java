package com.mail.interfaces;

import com.mail.dto.MailDTO;

public interface IMailManager {

    boolean submit(final MailDTO mailDTO);
}
