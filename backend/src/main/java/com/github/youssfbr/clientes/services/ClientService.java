package com.github.youssfbr.clientes.services;

import com.github.youssfbr.clientes.model.entities.Client;
import com.github.youssfbr.clientes.model.repositories.ClientRepository;
import com.github.youssfbr.clientes.services.exceptions.DatabaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository repository;

    @Autowired
    public ClientService(ClientRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<Client> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Client findById(Long id) {
        return repository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Id " + id + " not found!"));
    }

    @Transactional
    public Client insert(Client client) {
        return repository.save(client);
    }

    @Transactional
    public Client update(Long id, Client client) {
        try {
            Client entity = repository.getOne(id);
            entity.setName(client.getName());
            entity.setCpf(client.getCpf());
            return repository.save(entity);
        }
        catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id " + id + " not found!");
        }
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id " + id + " not found!");
        }
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Integrity Violation!");
        }
    }
}
