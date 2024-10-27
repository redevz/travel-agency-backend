//package com.takima.travel_agency.Entities;
//
//import com.takima.travel_agency.Entities.Enums.Sexe;
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
//public class Client {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//    private String firstName;
//    private String lastName;
//    private String email;
//    private String phoneNumber;
//    private Integer age;
//    private Sexe sexe;
//    @ManyToOne
//    @JoinColumn(nullable = false)
//    private Agency agency;
//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(
//            joinColumns = {@JoinColumn(name = "client_id")},
//            inverseJoinColumns = {@JoinColumn(name = "travel_id")}
//    )
//    private List<Travel> travels;
//}
