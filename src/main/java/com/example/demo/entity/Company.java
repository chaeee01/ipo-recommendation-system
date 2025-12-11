package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Company {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer companyId;

    private String name;
    private String industry;
    private Integer financialScore;
}
