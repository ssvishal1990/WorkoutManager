package org.example.workoutmanager.web.controller;

import org.example.workoutmanager.Service.ClientService;
import org.example.workoutmanager.data.dto.ClientDto;
import org.example.workoutmanager.data.requestbody.ClientRequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/client")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping(path = "/")
    public Optional<List<ClientDto>> getAllClient(){
        return clientService.getAllClients();
    }

    @PostMapping(path = "/save",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public HttpStatus saveClient(@RequestBody ClientRequestBody clientRequestBody){
        clientService.saveClient(clientRequestBody);
        return HttpStatus.OK;
    }
}
