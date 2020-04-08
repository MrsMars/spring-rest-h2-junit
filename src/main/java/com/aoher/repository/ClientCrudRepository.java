package com.aoher.repository;

import com.aoher.persistence.ClientEntity;

import java.util.List;

public interface ClientCrudRepository {

    List<ClientEntity> getClients();

    ClientEntity getById(long id);

    void createClient(ClientEntity clientEntity);

    void deleteById(long id);

    void updateClient(ClientEntity clientEntity, long id);
}
