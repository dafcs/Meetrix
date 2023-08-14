//package com.Meetrix.models;
//
//import com.Meetrix.models.enums.DietaryRequirement;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "dietary_requirements")
//public class DietaryTable {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//
//    @Column(name = "id")
//    private Long id;
//
//    @Column(name = "requirement")
//    private DietaryRequirement requirement;
//
//    public DietaryTable() {
//    }
//
//    public DietaryTable(DietaryRequirement requirement) {
//        this.requirement = requirement;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public DietaryRequirement getRequirement() {
//        return requirement;
//    }
//
//    public void setRequirement(DietaryRequirement requirement) {
//        this.requirement = requirement;
//    }
//}
