package com.aoher.controller;

import com.aoher.model.Client;
import com.aoher.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/crud")
public class ClientController {

    private final ClientService service;

    public ClientController(ClientService service) {
        this.service = service;
    }

    @GetMapping("/Clients")
    @ResponseStatus(HttpStatus.OK)
    public List<Client> getClients() {
        return service.getClients();
    }

    @GetMapping("/Clients/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Client> getById(@PathVariable long id) {
        Client client = service.getById(id);
        return ResponseEntity.ok().body(client);
    }

    @PostMapping("/Clients")
    public ResponseEntity<String> createClient(@RequestBody Client client) {
        service.createClient(client);
        return new ResponseEntity<>(" Client CREATED : client ", HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/Clients/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable long id){
        service.deleteById(id);
        return new ResponseEntity<>(" Client DELETED   : client ", HttpStatus.OK);
    }

    @PutMapping(value = "/Clients/{id}")
    public ResponseEntity<String> updateClient(@PathVariable long id,
                                               @RequestBody Client client){
        service.updateClient(id, client);
        return new ResponseEntity<>(" Client UPDATED   : client ", HttpStatus.OK);
    }

}
