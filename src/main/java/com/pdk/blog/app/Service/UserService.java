package com.pdk.blog.app.Service;

import java.util.List;

import com.pdk.blog.app.Payloads.UserDto;

public interface UserService {

    UserDto createUser(UserDto user);

    UserDto updateUser(UserDto user, Integer id);

    UserDto getUserById(Integer id);

    List<UserDto> getAllUser();

    void deleteUser(Integer userId);
}
