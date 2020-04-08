package com.aoher.repository.impl;


import com.aoher.persistence.ClientEntity;
import com.aoher.repository.ClientCrudRepository;
import com.aoher.repository.JPAClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClientCrudRepositoryImpl implements ClientCrudRepository {

    @Autowired
    private JPAClients jpaClients;

    @Override
    public List<ClientEntity> getClients() {
        return jpaClients.findAll();
    }

    @Override
    public ClientEntity getById(long id) {
        return jpaClients.findById(id).orElse(null);
    }

    @Override
    public void createClient(ClientEntity clientEntity) {
        jpaClients.save(clientEntity);
    }

    @Override
    public void deleteById(long id) {
        jpaClients.deleteById(id);
    }

    @Override
    public void updateClient(ClientEntity clientEntity, long id) {
        ClientEntity response = jpaClients.findById(id).orElse(null);
        if (response != null) {
            response.setName(clientEntity.getName());
            response.setLastName(clientEntity.getLastName());
            response.setGender(clientEntity.getGender());
            response.setAge(clientEntity.getAge());
            jpaClients.save(response);
        }
    }
}
