package com.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "OWNER")
public class Owner implements Serializable {


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    @Column
    private String surname;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "owner_id")
    private Set<Mail> mails;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "owner_id")
    private Set<Web> webSet;

    public Owner(String name, String surname){
        this.name = name;
        this.surname = surname;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Set<Mail> getMails() {
        return mails;
    }

    public void setMails(Set<Mail> mails) {
        this.mails = mails;
    }

    public Set<Web> getWebSet() {
        return webSet;
    }

    public void setWebSet(Set<Web> webSet) {
        this.webSet = webSet;
    }
}
