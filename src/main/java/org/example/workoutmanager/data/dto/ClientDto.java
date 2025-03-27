package org.example.workoutmanager.data.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.example.workoutmanager.data.enums.WorkoutType;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ClientDto {
    private UUID id;
    private String name;
    private List<WorkoutEntry> workoutOnDay;
}
