package org.example.service;

import org.example.model.Client;
import org.example.repository.ClientRepository;

import java.util.ArrayList;

public class ClientServiceImpl implements IClientService{

    private ClientRepository repository;
    public ClientServiceImpl() {
        repository = ClientRepository.getClientRepository();
    }

    public void add(Client client) {
        repository.add(client);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public ArrayList findAll() {
        return repository.findAll();
    }


    public void update(Client client) {
        repository.update(client);
    }

    public Client findByDni(String dni) {
        return repository.findByDni(dni);
    }
}
