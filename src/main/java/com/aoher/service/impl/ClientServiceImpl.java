package com.aoher.service.impl;

import com.aoher.mapper.OrikaMapper;
import com.aoher.model.Client;
import com.aoher.persistence.ClientEntity;
import com.aoher.repository.ClientCrudRepository;
import com.aoher.service.ClientService;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientCrudRepository repository;

    private MapperFacade facade = new OrikaMapper();

    @Override
    public List<Client> getClients() {
        List<ClientEntity> responseEntity = repository.getClients();
        return responseEntity.stream()
                .map(c -> facade.map(c, Client.class))
                .collect(Collectors.toList());
    }

    @Override
    public Client getById(long id) {
        ClientEntity clientEntity = repository.getById(id);
        return facade.map(clientEntity, Client.class);
    }

    @Override
    public void createClient(Client client) {
        ClientEntity clientEntity = facade.map(client, ClientEntity.class);
        repository.createClient(clientEntity);
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }

    @Override
    public void updateClient(long id, Client client) {
        ClientEntity clientEntity = facade.map(client, ClientEntity.class);
        repository.updateClient(clientEntity, id);
    }
}
