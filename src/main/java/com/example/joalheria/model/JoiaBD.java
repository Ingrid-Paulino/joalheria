package com.example.joalheria.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "joias")
public class JoiaBD {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long identificationNumber;

    @Column(length = 15, nullable = false)
    @NotNull(message = "The material of the joia cannot be empty.")
    private String material;

    @Column(nullable = false)
    @NotNull(message = "The peso of the joia cannot be empty.")
    private double peso;

    @Column(nullable = false)
    @NotNull(message = "The quilates of the joia cannot be empty.")
    private int quilates;
}
