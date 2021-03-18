package com.repository;

import com.models.Mail;
import com.models.Owner;
import com.repository.interfaces.IOwnerRepository;

import javax.enterprise.context.RequestScoped;
import java.util.HashSet;
import java.util.Set;

@RequestScoped
public class OwnerRepository extends MarkOneRepository<Owner> implements IOwnerRepository {

    public void addOwner(final String name, final String surname){
        Owner owner = new Owner(name, surname);

        Mail mail = new Mail();
        mail.setEmail("Adrian.Dumke@web.de");
        mail.setPassword("123");

        Set<Mail> mails = new HashSet<>();
        mails.add(mail);

        owner.setMails(mails);
        super.save(owner);
    }
}
