package org.example.workoutmanager.data.requestbody;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.example.workoutmanager.data.enums.WorkoutType;

import java.util.Date;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ClientRequestBody {
    String name;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    Date date;
    List<WorkoutType> workoutType;
}
