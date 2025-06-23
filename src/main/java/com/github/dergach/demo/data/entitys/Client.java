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
    private Long client_id;

    @Column(nullable = false)
    private String last_name;

    @Column(nullable = false)
    private String first_name;

    @Column
    private String patronymic;

    @Column(nullable = false)
    private String passport_number;

    @Column(nullable = false)
    private String passport_series;

    @Column(nullable = false)
    private LocalDate passport_issued_date;
}
