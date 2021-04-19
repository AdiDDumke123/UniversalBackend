package com.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "WEB")
public class Web {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String address;

    @Column
    private String owner_id;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Recaptcha recaptcha;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(String owner_id) {
        this.owner_id = owner_id;
    }

    public Recaptcha getRecaptcha() {
        return recaptcha;
    }

    public void setRecaptcha(Recaptcha recaptcha) {
        this.recaptcha = recaptcha;
    }
}
