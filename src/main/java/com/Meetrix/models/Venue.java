package com.Meetrix.models;

import com.Meetrix.models.enums.DietaryRequirement;
import com.Meetrix.models.enums.PriceRange;
import com.Meetrix.models.enums.VenueType;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="venues")

public class Venue {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name="venue_type")
    private VenueType venueType;

    @ElementCollection
    private List<DietaryRequirement> dietaryOptions;
    @Column(name = "capacity")
    private int capacity;

    @Column(name = "age_minimum")
    private int ageMinimum;

    @Column(name = "price_range")
    private PriceRange priceRange;
//    @Column(name = "contact")
//    private Contact contact;

    @OneToMany(mappedBy = "venue")
    private List<Event> events;


    public Venue() {
    }

    public Venue(Long id, String name, VenueType type, List<DietaryRequirement> dietaryOptions, int capacity, int ageMinimum, PriceRange priceRange) {
        this.id = id;
        this.name = name;
        this.venueType = type;
        this.dietaryOptions = dietaryOptions;
        this.capacity = capacity;
        this.ageMinimum = ageMinimum;
        this.priceRange = priceRange;
//        this.contact = contact;
    }

//    public Contact getContact() {
//        return contact;
//    }
//
//    public void setContact(Contact contact) {
//        this.contact = contact;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public VenueType getVenueType() {
        return venueType;
    }

    public void setVenueType(VenueType venueType) {
        this.venueType = venueType;
    }

//    public List<DietaryRequirement> getDietaryOptions() {
//        return dietaryOptions;
//    }
//
//    public void setDietaryOptions(List<DietaryRequirement> dietaryOptions) {
//        this.dietaryOptions = dietaryOptions;
//    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getAgeMinimum() {
        return ageMinimum;
    }

    public void setAgeMinimum(int ageMinimum) {
        this.ageMinimum = ageMinimum;
    }

    public PriceRange getPriceRange() {
        return priceRange;
    }

    public void setPriceRange(PriceRange priceRange) {
        this.priceRange = priceRange;
    }
}
