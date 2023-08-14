package com.Meetrix.models;

import javax.persistence.*;

@Entity
@Table(name = "contacts")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "email_address")
    private String emailAddress;
    @Column(name = "phone_number")
    private Long phoneNumber;
    @Column(name = "website")
    private String website;

    public Contact() {
    }

    public Contact(String emailAddress, Long phoneNumber, String website) {
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.website = website;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
