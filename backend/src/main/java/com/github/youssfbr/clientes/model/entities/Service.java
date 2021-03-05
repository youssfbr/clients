package com.github.youssfbr.clientes.model.entities;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@Table(name = "tb_service")
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
