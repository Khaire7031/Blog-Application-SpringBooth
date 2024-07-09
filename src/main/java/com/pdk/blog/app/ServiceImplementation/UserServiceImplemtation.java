package com.pdk.blog.app.ServiceImplementation;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pdk.blog.app.Entity.User;
import com.pdk.blog.app.Exception.ResourceNotFoundException;
import com.pdk.blog.app.Payloads.UserDto;
import com.pdk.blog.app.Repository.UserRepository;
import com.pdk.blog.app.Service.UserService;

@Service
public class UserServiceImplemtation implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = this.dtoToUser(userDto);
        User savedUser = this.userRepository.save(user);
        return this.userToDto(savedUser);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer id) {
        User user = this.userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", " id", id));

        user.setName(userDto.getName());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());
        user.setAbout(userDto.getAbout());

        User updatedUser = userRepository.save(user);

        return userToDto(updatedUser);
    }

    @Override
    public UserDto getUserById(Integer id) {
        User user = this.userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", " Id", id));
        return this.userToDto(user);
    }

    @Override
    public List<UserDto> getAllUser() {
        List<User> users = this.userRepository.findAll();
        List<UserDto> existingUsers = users.stream().map(user -> userToDto(user)).toList();
        return existingUsers;
    }

    @Override
    public void deleteUser(Integer userId) {
        User user = this.userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", " Id", userId));

        userRepository.delete(user);
    }

    private User dtoToUser(UserDto userDto) {
        User user = this.modelMapper.map(userDto, User.class);

        // user.setEmail(userDto.getEmail());
        // user.setId(userDto.getId());
        // user.setName(userDto.getName());
        // user.setPassword(userDto.getPassword());
        // user.setAbout(userDto.getAbout());
        return user;
    }

    private UserDto userToDto(User user) {
        UserDto userDto = this.modelMapper.map(user, UserDto.class);
        // userDto.setPassword(user.getPassword());
        // userDto.setEmail(user.getEmail());
        // userDto.setId(user.getId());
        // userDto.setName(user.getName());
        // userDto.setAbout(user.getAbout());
        return userDto;
    }

}
