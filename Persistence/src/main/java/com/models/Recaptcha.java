package com.models;

import javax.persistence.*;

@Entity
@Table(name = "RECAPTCHA")
public class Recaptcha {

    @Id
    private long id;

    @Column
    private String sec_token;

    @Column
    private String url;

    @Column
    private String salt;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSec_token() {
        return sec_token;
    }

    public void setSec_token(String sec_token) {
        this.sec_token = sec_token;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
