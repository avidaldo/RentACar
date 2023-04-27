package org.example.controller;

import org.example.model.Client;
import org.example.service.ClientServiceImpl;
import org.example.service.IClientService;

import java.util.List;

public class ClientController {

    private final IClientService service;
    public ClientController() {
        service = new ClientServiceImpl();
    }

    public void add(String dni, String name, String surname){
        Client client = new Client(dni, name, surname);  // Sin id
        service.add(client);
    }

    public void deleteById(Long id){
        service.deleteById(id);
    }

    public List<Client> findAll(){
        return service.findAll();
    }

    public Client findByDni(String dni){
        return service.findByDni(dni);
    }

    public void update(Long id, String dni, String name, String surname){
        Client client = new Client(id, dni, name, surname);
        service.update(client);
    }


}
