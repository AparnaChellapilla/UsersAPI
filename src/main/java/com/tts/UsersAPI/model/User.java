package com.tts.UsersAPI.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

   @Size(min = 2, max = 25)
    private String firstName;
    @Size(min = 2, max = 20)
    private String lastName;
    @Size(min = 2, max = 20)
    private String state;


}
