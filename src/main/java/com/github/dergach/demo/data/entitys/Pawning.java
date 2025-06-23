package com.github.dergach.demo.data.entitys;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "pawnings")
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Pawning {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pawning_id")
    private Long pawningId;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    @ToString.Exclude
    private ProductCategory category;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    @ToString.Exclude
    private Client client;

    @Column(name = "product_description", nullable = false)
    private String productDescription;

    @Column(name = "date_received", nullable = false)
    private LocalDate dateReceived;

    @Column(name = "return_deadline", nullable = false)
    private LocalDate returnDeadline;

    @Column(nullable = false)
    private BigDecimal amount;

    @Column(nullable = false)
    private BigDecimal commission;
}
