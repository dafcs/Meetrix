package com.Meetrix.models;

import com.Meetrix.models.enums.DietaryRequirement;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;

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

    @ManyToMany
    @JsonIgnoreProperties({"members"})
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(
            name = "members_events",
            joinColumns = { @JoinColumn(name = "member_id",
            nullable = false,
            updatable = false)
            },
            inverseJoinColumns = { @JoinColumn(
                    name = "event_id",
                    nullable = false,
                    updatable = false)
            })
    private List<Event> events;

    public List<Event> getEvent() {
        return events;
    }

    public void setEvent(List<Event> events) {
        this.events = events;
    }


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
