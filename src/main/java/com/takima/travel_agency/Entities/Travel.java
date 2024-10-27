//package com.takima.travel_agency.Entities;
//
//import com.takima.travel_agency.Entities.Enums.TravelType;
//import jakarta.persistence.*;
//import lombok.*;
//
//import java.util.List;
//
//@Entity
//@Table
//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
//@Builder
//public class Travel {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//    private String departure;
//    private String arrival;
//    private Double price;
//    private boolean isPremium;
//    private TravelType type;
//    private String description;
//    @ManyToOne
//    @JoinColumn(nullable = false)
//    private Agency agency;
//    @ManyToMany(mappedBy = "travels")
//    private List<Client> clients;
//}
