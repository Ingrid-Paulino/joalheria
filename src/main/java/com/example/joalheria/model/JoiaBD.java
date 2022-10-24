package com.example.joalheria.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "joias")
public class JoiaBD {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long identificationNumber;

    @Column(length = 15, nullable = false)
    private String material;

    @Column(nullable = false)
    private double peso;

    @Column(nullable = false)
    private int quilates;
}
