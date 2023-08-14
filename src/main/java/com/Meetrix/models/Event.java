package com.Meetrix.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String eventName;

    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    @JsonIgnoreProperties({"events"})
    private Member organiser;

//    @OneToMany(mappedBy = "events")
//    private List<Venue> potentialVenues;

    @ManyToOne
    @JoinColumn(name = "venue_id")
    @JsonIgnoreProperties({"events"})
    private Venue venue;

//    private List<LocalDateTime> potentialDateTimes;

    @Column(name = "chosen_date_time")
    private LocalDateTime chosenDateTime;

    @ManyToMany
    @JsonIgnoreProperties({"events"})
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(
            name = "members_events",
            joinColumns = { @JoinColumn(name = "event_id",
                    nullable = false,
                    updatable = false)
            },
            inverseJoinColumns = { @JoinColumn(
                    name = "member_id",
                    nullable = false,
                    updatable = false)
            })
    private List<Member> members;


    public Event() {
    }

    public Event(String eventName, Member organiser) {
        this.eventName = eventName;
        this.organiser = organiser;
        this.members = new ArrayList<>();
        this.chosenDateTime = null;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

//    public List<Member> getAttendees() {
//        return attendees;
//    }
//
//    public void setAttendees(List<Member> attendees) {
//        this.attendees = attendees;
//    }

    public Member getOrganiser() {
        return organiser;
    }

    public void setOrganiser(Member organiser) {
        this.organiser = organiser;
    }

//    public List<Venue> getPotentialVenues() {
//        return potentialVenues;
//    }
//
//    public void setPotentialVenues(List<Venue> potentialVenues) {
//        this.potentialVenues = potentialVenues;
//    }

    public Venue getChosenVenue() {
        return venue;
    }

    public void setChosenVenue(Venue chosenVenue) {
        this.venue = chosenVenue;
    }

//    public List<LocalDateTime> getPotentialDateTimes() {
//        return potentialDateTimes;
//    }
//
//    public void setPotentialDateTimes(List<LocalDateTime> potentialDateTimes) {
//        this.potentialDateTimes = potentialDateTimes;
//    }

    public LocalDateTime getChosenDateTime() {
        return chosenDateTime;
    }

    public void setChosenDateTime(LocalDateTime chosenDateTime) {
        this.chosenDateTime = chosenDateTime;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    public void addMember(Member member){
        members.add(member);
    }
}
