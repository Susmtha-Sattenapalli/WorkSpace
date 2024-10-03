package com.example.load;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
public class Load {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String loadingPoint;
    private String unloadingPoint;
    private String productType;
    private String truckType;
    private Integer noOfTrucks;
    private Integer weight;
    private String comment;
    private UUID shipperId;
    private LocalDate date;
}
