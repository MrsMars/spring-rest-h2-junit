package com.aoher.util;

import com.aoher.persistence.ClientEntity;

public class DummyFactory {

    public ClientEntity getDummyClient() {

        ClientEntity clientEntity = new ClientEntity();

        clientEntity.setId(1L);
        clientEntity.setName("Dummy");
        clientEntity.setLastName("DummyLastName");
        clientEntity.setAge("23");
        clientEntity.setGender("GenderDummy");

        return clientEntity;
    }
}
