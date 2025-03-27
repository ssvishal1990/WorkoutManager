package org.example.workoutmanager.data.Utility;

import org.example.workoutmanager.data.enums.WorkoutType;

import java.util.Date;

public record DateAndWorkout(Date date, WorkoutType workoutType) {
}
