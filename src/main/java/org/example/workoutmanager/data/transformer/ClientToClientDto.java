package org.example.workoutmanager.data.transformer;

import org.example.workoutmanager.data.Utility.DateAndWorkout;
import org.example.workoutmanager.data.dto.ClientDto;
import org.example.workoutmanager.data.dto.WorkoutEntry;
import org.example.workoutmanager.data.entity.Client;
import org.example.workoutmanager.data.enums.WorkoutType;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;

@Component
public class ClientToClientDto {


    public List<ClientDto> transform(List<Client> clients, Map<UUID, List<DateAndWorkout>> clientIdAndDateAndWorkout) {
        var clientDtos = new ArrayList<ClientDto>();
        for(var client : clients){
            var clientDto = ClientDto.builder()
                    .id(client.getId())
                    .name(client.getName())
                    .workoutOnDay(prepareWorkoutAndDateMap(clientIdAndDateAndWorkout.get(client.getId())))
                    .build();
            clientDtos.add(clientDto);
        }
        return clientDtos;
    }


    private List<WorkoutEntry> prepareWorkoutAndDateMap(List<DateAndWorkout> dateAndWorkouts){
        var list = new ArrayList<WorkoutEntry>();
        for(var v : dateAndWorkouts){
            Instant instant = v.date().toInstant();
            ZonedDateTime zone = instant.atZone(ZoneId.systemDefault());
            LocalDate givenDate = zone.toLocalDate();
            var existing = list.stream().filter(e -> e.getDate().equals(givenDate)).findAny();
            if(existing.isPresent()){
                var currentWorkoutType = existing.get().getWorkouts();
                currentWorkoutType.add(v.workoutType());
                existing.get().setWorkouts(currentWorkoutType);
            }else{
                list.add(new WorkoutEntry(givenDate, Collections.singletonList(v.workoutType())));
            }
        }
        return list;
    }
}
