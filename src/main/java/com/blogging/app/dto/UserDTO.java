package com.blogging.app.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDTO {

    private Integer id;
    private String username;
    private String email;
    private String password;
    private String about;
}
