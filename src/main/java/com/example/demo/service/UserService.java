package com.example.demo.service;


import com.example.demo.dto.UserDTO;
import com.example.demo.model.User;
import com.example.demo.repository.UseRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    private UseRepository useRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<UserDTO> getAllUsers() {
        List<User> userList = useRepository.findAll();
        return modelMapper.map(userList, new TypeToken<List<UserDTO>>(){}.getType());
    }

    public UserDTO saveUser(UserDTO userDTO){
        useRepository.save(modelMapper.map(userDTO,User.class));
        return userDTO;
    }

    public UserDTO updateUser(UserDTO userDTO){
        useRepository.save(modelMapper.map(userDTO,User.class));
        return userDTO;
    }

    public  String deleteUser(UserDTO userDTO){
        useRepository.delete(modelMapper.map(userDTO, User.class));
        return "User Deleted";
    }
}
