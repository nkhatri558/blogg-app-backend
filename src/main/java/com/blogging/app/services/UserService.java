package com.blogging.app.services;

import com.blogging.app.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    public UserDTO addUser(UserDTO userDTO);
    public UserDTO updateUser(UserDTO userDTO, Integer userId);
    public List<UserDTO> getAllUsers();
    public void deleteUser(Integer userId);
    public UserDTO getUserById(Integer userId);

}
