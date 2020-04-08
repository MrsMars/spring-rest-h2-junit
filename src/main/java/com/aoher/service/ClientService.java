package com.aoher.service;

import com.aoher.model.Client;

import java.util.List;

public interface ClientService {

    List<Client> getClients();

    Client getById(long id);

    void createClient(Client client);

    void deleteById(long id);

    void updateClient(long id, Client client);
}
