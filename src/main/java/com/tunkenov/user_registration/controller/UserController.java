package com.tunkenov.user_registration.controller;

import com.tunkenov.user_registration.dto.UserDTO;
import com.tunkenov.user_registration.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/users")
@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserDTO> findAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public UserDTO findUser(@PathVariable("id") Long id) {
        return userService.getOne(id);
    }

    @PutMapping
    @ResponseBody
    public UserDTO saveUser(@RequestBody UserDTO userDTO) {
        return userService.saveUser(userDTO);
    }

    @PostMapping("/{id}")
    @ResponseBody
    public UserDTO updateUser(@PathVariable("id") Long id, @RequestBody UserDTO userDTO) {
        return userService.updateUser(id, userDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
    }

}
