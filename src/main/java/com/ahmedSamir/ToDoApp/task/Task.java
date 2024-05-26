package com.ahmedSamir.ToDoApp.task;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message ="Please enter the title")
    private String title;
    @NotBlank(message ="Please enter the description")
    private String description;
    @FutureOrPresent(message = "start date can't be in the past")
    @NotNull(message = "please choose start date")
    private LocalDate start_date;
    @FutureOrPresent(message = "finish date can't be in the past")
    @NotNull(message = "please choose target finish date")
    private LocalDate finish_date;
    private boolean completed;
}
