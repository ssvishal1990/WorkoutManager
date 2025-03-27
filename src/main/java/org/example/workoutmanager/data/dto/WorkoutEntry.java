package org.example.workoutmanager.data.dto;

import lombok.*;
import org.example.workoutmanager.data.enums.WorkoutType;

import java.time.LocalDate;
import java.util.List;


@Data
@AllArgsConstructor
public class WorkoutEntry {
    private LocalDate date;
    private List<WorkoutType> workouts;
}
