package com.javabrains.project.Online.voting.system.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "voter")
public class Voter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank(message = "can not be blank")
    private String firstname;
    private String lastname;
    @NotBlank(message = "can not be blank")
    private String mobile;
    @NotBlank(message = "can not be blank")
    private String email;
    @NotBlank(message = "can not be blank")
    private String place;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd")
    @NotNull
    private Date dateOfBirth;
}

