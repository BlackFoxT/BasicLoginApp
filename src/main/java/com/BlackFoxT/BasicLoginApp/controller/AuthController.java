package com.BlackFoxT.BasicLoginApp.controller;

import com.BlackFoxT.BasicLoginApp.dto.UserDto;
import com.BlackFoxT.BasicLoginApp.mapper.UserMapper;
import com.BlackFoxT.BasicLoginApp.model.User;
import com.BlackFoxT.BasicLoginApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/signup")
    public String signupPage() {
        return "signup";
    }

    @PostMapping("/signup")
    public String registerUser(@ModelAttribute UserDto userDto, Model model) {
        if (userService.findByEmail(userDto.getEmail()).isPresent()) {
            model.addAttribute("error", "User already exists!");
            return "signup";
        }

        if (!userDto.getPassword().equals(userDto.getConfirmPassword())) {
            model.addAttribute("error", "Passwords do not match!");
            return "signup";
        }

        User newUser = UserMapper.toEntity(userDto);
        userService.saveUser(newUser);

        return "redirect:/auth/login";
    }
}
