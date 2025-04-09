package com.example.puzzleappbackend.completed;

import com.example.puzzleappbackend.puzzle.Puzzle;
import com.example.puzzleappbackend.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "completed")
public class Completed {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "completed_id")
    private Integer completedId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "puzzle_id")
    private Puzzle puzzle;

    @Column(name = "date")
    private Date date;

    @Column(name = "time")
    private Time time;

    @Column(name = "first_time")
    private Boolean firstTime;
}
