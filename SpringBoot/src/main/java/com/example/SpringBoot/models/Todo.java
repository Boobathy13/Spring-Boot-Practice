package com.example.SpringBoot.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Data
//@NoArgsConstructor
public class Todo {
    @Id
    @GeneratedValue
    Long id;

    @NotNull
    @NotBlank
            @Size(min = 5, max = 25)
    String title;
    @NotNull
    @NotBlank
    String description;
    @NotNull
    boolean isCompleted;

    @Email
    String email;
}
