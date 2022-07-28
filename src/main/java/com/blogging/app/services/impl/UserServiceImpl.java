package com.blogging.app.services.impl;

import com.blogging.app.dto.UserDTO;
import com.blogging.app.exceptions.ResourceNotFoundException;
import com.blogging.app.models.User;
import com.blogging.app.repositories.UserRepository;
import com.blogging.app.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDTO addUser(UserDTO userDTO) {
        User user = this.dtoToUser(userDTO);
        User savedUser = this.userRepository.save(user);
        return this.userToDTO(savedUser);
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO, Integer userId) {
        User user = this.userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setAbout(userDTO.getAbout());
        User savedUser = this.userRepository.save(user);
        return this.userToDTO(savedUser);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> userList = this.userRepository.findAll();
        return userList.stream().map(this::userToDTO).collect(Collectors.toList());
    }

    @Override
    public void deleteUser(Integer userId) {
        User user = this.userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
        this.userRepository.delete(user);
    }

    @Override
    public UserDTO getUserById(Integer userId) {
        User user = this.userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
        return this.userToDTO(user);
    }

    public UserDTO userToDTO(User user) {
        return this.modelMapper.map(user, UserDTO.class);
    }

    public User dtoToUser(UserDTO userDTO) {
        return this.modelMapper.map(userDTO, User.class);
    }
}
