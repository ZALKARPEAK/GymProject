package com.example.Trainee.Dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserCheckRequest {
    private String username;
    private String password;

}
