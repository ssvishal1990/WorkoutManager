package org.example.workoutmanager.web.graphql;

import org.example.workoutmanager.Service.ClientService;
import org.example.workoutmanager.data.dto.ClientDto;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class ClientGraphiqlController {

    private final ClientService clientService;

    public ClientGraphiqlController(ClientService clientService) {
        this.clientService = clientService;
    }

    @QueryMapping
    public Optional<List<ClientDto>> clients() {
        return clientService.getAllClients();
    }
}
