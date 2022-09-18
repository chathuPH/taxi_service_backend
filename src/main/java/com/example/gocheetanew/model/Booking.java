package com.example.gocheetanew.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Booking")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Booking {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "fee")
    private double fee;

    @Column(name = "source")
    private String source;

    @Column(name = "destination")
    private String destination;

    @Column(name = "distance")
    private double distance;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "driver")
    private Driver driver;

    @ManyToOne
    @JoinColumn(name = "vehicle")
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "customer")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "category")
    private Category category;



}
