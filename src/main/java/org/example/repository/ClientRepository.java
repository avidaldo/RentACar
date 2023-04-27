package org.example.repository;

import org.example.model.Client;
import org.example.model.Entity;


public class ClientRepository extends CrudRepository {

    private static ClientRepository clientRepository;

    private ClientRepository() {
        super();
    }

    public static ClientRepository getClientRepository() {
        if(clientRepository == null){
            clientRepository = new ClientRepository();
        }
        return clientRepository;
    }


    public Client findByDni(String dni){
        for (Entity c : array) {
            Client client = (Client) c;
            if(client.getDni() == dni){
                return (Client) c;
            }
        }
        return null;
    }

}
