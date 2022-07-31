package com.blogging.app.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Getter
@Setter
public class UserDTO {

    private Integer id;

    @NotEmpty
    @Size(min = 4, max = 20, message = "Username should be minimum of size 4 and maximum of size 20")
    private String username;
    @NotEmpty(message = "Email should not be empty")
    @Email(message = "Email is not valid")
    private String email;
    @NotEmpty
    @Size(min = 6, max = 15, message = "Password should be minimum of 6 characters and maximum of 15 characters")
    private String password;
    @NotEmpty
    private String about;
}
