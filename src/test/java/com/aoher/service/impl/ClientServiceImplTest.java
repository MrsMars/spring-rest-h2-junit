package com.aoher.service.impl;

import com.aoher.mapper.OrikaMapper;
import com.aoher.model.Client;
import com.aoher.persistence.ClientEntity;
import com.aoher.repository.ClientCrudRepository;
import ma.glasnost.orika.MapperFacade;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Collections;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class ClientServiceImplTest {

    @Mock
    private ClientCrudRepository repository;

    @Mock
    private MapperFacade facade = new OrikaMapper();

    @InjectMocks
    private ClientServiceImpl service;

    static long id;
    private static ClientEntity clientEntity;
    private static Client client;

    @BeforeClass
    public static void setUp() {
        id = 1;
        clientEntity = new ClientEntity();
        client = new Client();
    }

    @Test
    public void getClients() {
        when(repository.getClients()).thenReturn(Collections.singletonList(clientEntity));
        when(facade.map(clientEntity, Client.class)).thenReturn(client);

        assertNotNull(service.getClients());
    }

    @Test
    public void getById() {
        when(repository.getById(id)).thenReturn(clientEntity);
        when(facade.map(clientEntity, Client.class)).thenReturn(client);

        assertNotNull(service.getById(id));
    }

    @Test
    public void createClient() {
        when(facade.map(client, ClientEntity.class)).thenReturn(clientEntity);
        doNothing().when(repository).createClient(clientEntity);

        service.createClient(client);
    }

    @Test
    public void deleteById() {
        doNothing().when(repository).deleteById(id);

        service.deleteById(id);
    }

    @Test
    public void updateClient() {
        when(facade.map(client, ClientEntity.class)).thenReturn(clientEntity);
        doNothing().when(repository).updateClient(clientEntity, id);

        service.updateClient(id, client);
    }
}