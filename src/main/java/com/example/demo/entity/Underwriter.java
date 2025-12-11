package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Underwriter {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer underwriterId;

    private String name;
}
