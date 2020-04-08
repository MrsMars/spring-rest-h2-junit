package com.aoher.controller;

import com.aoher.model.Client;
import com.aoher.service.impl.ClientServiceImpl;
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
public class ClientControllerTest {

    @Mock
    private ClientServiceImpl service;

    @InjectMocks
    private ClientController controller;

    private Client clients = new Client();
    private long id=1;

    @Test
    public void getClients() {
        when(service.getClients()).thenReturn(Collections.singletonList(clients));
        assertNotNull(controller.getClients());
    }

    @Test
    public void getClientsById() {
        when(service.getById(id)).thenReturn(clients);
        assertNotNull(controller.getById(id));
    }

    @Test
    public void createClient() {
        doNothing().when(service).createClient(clients);
        assertNotNull(controller.createClient(clients));
    }

    @Test
    public void deleteClient() {
        doNothing().when(service).deleteById(id);
        assertNotNull(controller.deleteClient(id));
    }

    @Test
    public void updateClient() {
        doNothing().when(service).updateClient(id, clients);
        assertNotNull(controller.updateClient(id, clients));
    }
}