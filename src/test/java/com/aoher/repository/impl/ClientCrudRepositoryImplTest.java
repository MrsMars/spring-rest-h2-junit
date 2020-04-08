package com.aoher.repository.impl;

import com.aoher.persistence.ClientEntity;
import com.aoher.repository.JPAClients;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Collections;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class ClientCrudRepositoryImplTest {

    @Mock
    private JPAClients jpaClients;

    @InjectMocks
    private ClientCrudRepositoryImpl repository;

    private static long id;
    private static ClientEntity client;
    private static Optional<ClientEntity> oPclient;

    @BeforeClass
    public static void setUp() {
        id = 1;
        client = new ClientEntity();
        oPclient = Optional.of(client);
    }

    @Test
    public void getClients() {
        when(jpaClients.findAll()).thenReturn(Collections.singletonList(client));

        assertNotNull(repository.getClients());
    }

    @Test
    public void getById() {
        when(jpaClients.findById(id)).thenReturn(oPclient);

        assertNotNull(repository.getById(id));
    }

    @Test
    public void createClient() {
        when(jpaClients.save(client)).thenReturn(new ClientEntity());
        repository.createClient(client);
    }

    @Test
    public void deleteById() {
        doNothing().when(jpaClients).deleteById(id);
        repository.deleteById(id);
    }

    @Test
    public void updateClient() {
        when(jpaClients.findById(id)).thenReturn(oPclient);
        when(jpaClients.save(client)).thenReturn(client);
        repository.updateClient(client, id);
    }
}