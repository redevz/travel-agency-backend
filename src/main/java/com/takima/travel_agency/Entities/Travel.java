package com.takima.travel_agency.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.takima.travel_agency.Entities.Enums.TravelType;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "travel")
public class Travel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String departure;
    @Column(nullable = false)
    private String arrival;
    @Temporal(TemporalType.TIMESTAMP)
    private Date scheduled;
    private Double price;
    @Column(name = "is_premium")
    private Boolean isPremium;
    private TravelType type;
    private String description;
    private Integer remainingPlaces;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "agency_id")
    private Agency agency;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "travel")
    private List<Traveler> travelers;

    public Travel() {}

    public Travel(Integer id, String departure, String arrival, Date scheduled, Double price, Boolean isPremium, TravelType type, String description, Integer remainingPlaces, Agency agency, List<Traveler> travelers) {
        this.id = id;
        this.departure = departure;
        this.arrival = arrival;
        this.scheduled = scheduled;
        this.price = price;
        this.isPremium = isPremium;
        this.type = type;
        this.description = description;
        this.remainingPlaces = remainingPlaces;
        this.agency = agency;
        this.travelers = travelers;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public Date getScheduled() { return scheduled; }

    public void setScheduled(Date scheduled) { this.scheduled = scheduled; }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean isPremium() {
        return isPremium;
    }

    public void setIsPremium(Boolean premium) {
        isPremium = premium;
    }

    public TravelType getType() {
        return type;
    }

    public void setType(TravelType type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getRemainingPlaces() {
        return remainingPlaces;
    }

    public void setRemainingPlaces(Integer remainingPlaces) {
        this.remainingPlaces = remainingPlaces;
    }

    @JsonBackReference
    public Agency getAgency() {
        return agency;
    }

    public void setAgency(Agency agency) {
        this.agency = agency;
    }

    @JsonManagedReference
    public List<Traveler> getTravelers() {
        return travelers;
    }

    public void setTravelers(List<Traveler> travelers) {
        this.travelers = travelers;
    }
}
