package com.github.youssfbr.clientes.model.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "tb_client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    @NotEmpty(message = "{field.name.required}")
    private String name;

    @Column(nullable = false, length = 11)
    @NotEmpty(message = "{field.cpf.required}")
    @CPF(message = "{field.cpf.invalid}")
    private String cpf;

    @Column(name = "date_register", updatable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateRegister;

    @PrePersist
    public void prePersist() {
        setDateRegister(LocalDate.now());
    }
}
