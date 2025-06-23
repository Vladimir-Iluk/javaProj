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
    private Long pawning_id;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    @ToString.Exclude
    private ProductCategory category;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    @ToString.Exclude
    private Client client;

    @Column(nullable = false)
    private String product_description;

    @Column(nullable = false)
    private LocalDate date_received;

    @Column(nullable = false)
    private LocalDate return_deadline;

    @Column(nullable = false)
    private BigDecimal amount;

    @Column(nullable = false)
    private BigDecimal commission;
}
