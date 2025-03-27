package org.example.workoutmanager.Service;

import org.example.workoutmanager.data.Utility.DateAndWorkout;
import org.example.workoutmanager.data.dto.ClientDto;
import org.example.workoutmanager.data.entity.Client;
import org.example.workoutmanager.data.repository.ClientRepository;
import org.example.workoutmanager.data.requestbody.ClientRequestBody;
import org.example.workoutmanager.data.transformer.ClientToClientDto;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ClientService {

    private final ClientRepository clientRepository;
    private final ClientToClientDto clientToClientDto;

    public ClientService(ClientRepository clientRepository, ClientToClientDto clientToClientDto) {
        this.clientRepository = clientRepository;
        this.clientToClientDto = clientToClientDto;
    }

    public Optional<List<ClientDto>> getAllClients(){
        List<Client> clients = clientRepository.findAll();
        Map<UUID, List<DateAndWorkout>> clientIdAndDateAndWorkout = new HashMap<>();
        clients.forEach(c -> prepareClientIdAndDateAndWorkoutMap(c, clientIdAndDateAndWorkout));
        return Optional.of(clientToClientDto.transform(clients, clientIdAndDateAndWorkout));
    }

    private static void prepareClientIdAndDateAndWorkoutMap(Client c, Map<UUID, List<DateAndWorkout>> clientIdAndDateAndWorkout) {
        clientIdAndDateAndWorkout.putIfAbsent(c.getId(), new ArrayList<>());
        clientIdAndDateAndWorkout.get(c.getId()).add(new DateAndWorkout(c.getDate(), c.getWorkoutType()));
    }

    public void saveClient(ClientRequestBody clientRequestBody) {
        clientRequestBody.getWorkoutType().forEach(workoutType -> {
            Client client = Client.builder()
                    .id(UUID.randomUUID())
                    .name(clientRequestBody.getName())
                    .workoutType(workoutType)
                    .date(clientRequestBody.getDate())
                    .build();
            clientRepository.save(client);
        });

    }
}
