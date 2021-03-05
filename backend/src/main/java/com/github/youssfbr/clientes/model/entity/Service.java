package com.github.youssfbr.clientes.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String description;

    @Column
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client client;
}
