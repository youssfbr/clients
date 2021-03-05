package com.github.youssfbr.clientes.model.repositories;

import com.github.youssfbr.clientes.model.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
