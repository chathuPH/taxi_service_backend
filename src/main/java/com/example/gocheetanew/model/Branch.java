package com.example.gocheetanew.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Branch")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Branch {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "branchName")
    private String brnachName;

    @Column(name = "location")
    private String location;

    @Column(name = "contact_no")
    private String contactNo;

}
