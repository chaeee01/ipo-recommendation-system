package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter @Setter
public class IPO {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ipoId;

    private Double competitionRate;
    private String market;
    private Integer offeringPrice;
    private String priceRange;
    private LocalDate ipoDate;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToOne
    @JoinColumn(name = "underwriter_id")
    private Underwriter underwriter;
}
