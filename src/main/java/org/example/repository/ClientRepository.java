package org.example.repository;

import org.example.model.Client;

import java.util.ArrayList;
import java.util.List;

public class ClientRepository implements IClientRepository {

    private List<Client> clients = new ArrayList<>();

    private static ClientRepository clientRepository;
    public static ClientRepository getClientRepository() {
        if(clientRepository == null) clientRepository = new ClientRepository();
        return clientRepository;
    }

    public void add(Client client){
        client.setId(nextIdAvailable());
        clients.add(client);
    }

    private Long nextIdAvailable() {
        if (!clients.isEmpty())
            return clients.get(clients.size() - 1).getId() + 1;
        else return 1L;
    }

    public void update(Client client) {


        Client clientToUpdate = findById(client.getId());
        if (clientToUpdate != null) {
            clientToUpdate.setDni(client.getDni());
            clientToUpdate.setName(client.getName());
            clientToUpdate.setSurname(client.getSurname());
        }
    }

    public List<Client> findAll() {
        return clients;
    }

    public void deleteById(Long id) {
        for (Client client : clients) {
            if (client.getId().equals(id)) {
                clients.remove(client);
                break;
            }
        }
    }

    public Client findById(Long id) {
        for (Client client : clients) {
            if (client.getId().equals(id)) {
                return client;
            }
        }
        return null;
    }

    public Client findByDni(String dni) {
        for (Client client : clients) {
            if (client.getDni().equals(dni)) {
                return client;
            }
        }
        return null;
    }

    public void cleanUp(){
        clients = new ArrayList<>();
    }

}
