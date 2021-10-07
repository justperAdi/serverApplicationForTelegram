package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Currency {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "currency_seq")
    @SequenceGenerator(name = "currency_seq",sequenceName = "currency_seq", allocationSize = 1)
    private Long id;

    @Column(name = "date")
    private Date date;

    @Column(name = "usd")
    private Double usd;

    @Column(name = "eur")
    private Double eur;

    @Column(name = "rub")
    private Double rub;

}
