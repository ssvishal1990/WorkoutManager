package org.example.workoutmanager.data.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.workoutmanager.data.enums.WorkoutType;
import org.hibernate.annotations.Type;

import java.util.Date;
import java.util.UUID;

@Entity(name = "client")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "date")
    private Date date;

    @Column(name = "workout")
    @Enumerated(EnumType.STRING)
    private WorkoutType workoutType;
}
