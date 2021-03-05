package com.github.youssfbr.clientes.model.repositories;

import com.github.youssfbr.clientes.model.entities.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Long> {
}
