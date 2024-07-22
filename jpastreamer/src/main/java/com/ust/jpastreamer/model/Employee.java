package com.ust.jpastreamer.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee {
    @Id
    @GeneratedValue
    private int id;
    private String education;
    private int joiningYear;
    private String city;
    private int paymentTier;
    private int age;
    private String gender;
    private String everBenched;
    private int experienceInCurrentDomain;
    private int leaveOrNot;

}
