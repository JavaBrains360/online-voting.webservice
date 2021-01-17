package com.javabrains.project.Online.voting.system.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoginDetails {

    private String email;
    private String password;
}
