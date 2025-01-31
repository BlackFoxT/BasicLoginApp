package com.BlackFoxT.BasicLoginApp.mapper;

import com.BlackFoxT.BasicLoginApp.dto.UserDto;
import com.BlackFoxT.BasicLoginApp.model.User;

public class UserMapper {

    public static User toEntity(UserDto userDto) {
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        return user;
    }
}
