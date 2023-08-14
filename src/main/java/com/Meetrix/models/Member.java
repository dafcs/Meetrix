package com.Meetrix.models;

import com.Meetrix.models.enums.DietaryRequirement;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "members")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "username")
    private String username;
    @Column(name = "email_address")
    private String emailAddress;
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
//    @Column(name = "dietary_requirements")

    @ElementCollection
    private List<DietaryRequirement> dietaryRequirements;



    public Member() {
    }

    public Member(String username, String email, LocalDate dateOfBirth, List<DietaryRequirement> dietaryRequirements) {
        this.username = username;
        this.emailAddress = email;
        this.dateOfBirth = dateOfBirth;
        this.dietaryRequirements = dietaryRequirements;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmail(String email) {
        this.emailAddress = email;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

//    public List<DietaryRequirement> getDietaryRequirements() {
//        return dietaryRequirements;
//    }
//
//    public void setDietaryRequirements(List<DietaryRequirement> dietaryRequirements) {
//        this.dietaryRequirements = dietaryRequirements;
//    }
}
