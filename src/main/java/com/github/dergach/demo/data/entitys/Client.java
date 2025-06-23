package com.github.dergach.demo.data.entitys;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "clients")
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    private Long clientId;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column
    private String patronymic;

    @Column(name = "passport_number", nullable = false)
    private String passportNumber;

    @Column(name = "passport_series", nullable = false)
    private String passportSeries;

    @Column(name = "passport_issued_date", nullable = false)
    private LocalDate passportIssuedDate;
}
