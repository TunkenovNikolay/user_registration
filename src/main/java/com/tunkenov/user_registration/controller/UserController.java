package com.tunkenov.user_registration.controller;

import com.tunkenov.user_registration.dto.UserDTO;
import com.tunkenov.user_registration.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/users")
@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation("Загрузка всех пользователей.")
    @GetMapping
    public List<UserDTO> findAllUsers() {
        return userService.findAll();
    }

    @ApiOperation("Загрузка пользователя по id.")
    @GetMapping("/{id}")
    public UserDTO findUser(@ApiParam("ID пользователя.") @PathVariable("id") Long id) {
        return userService.getOne(id);
    }

    @ApiOperation("Регистрация нового пользователя.")
    @PutMapping
    @ResponseBody
    public UserDTO saveUser(@ApiParam("Имя и Фамилия пользователя.") @RequestBody UserDTO userDTO) {
        return userService.saveUser(userDTO);
    }

    @ApiOperation("Редактирование информации пользователя по id.")
    @PostMapping("/{id}")
    @ResponseBody
    public UserDTO updateUser(@ApiParam("ID пользователя.") @PathVariable("id") Long id,
                              @ApiParam("Новые данные пользователя.") @RequestBody UserDTO userDTO) {
        return userService.updateUser(id, userDTO);
    }

    @ApiOperation("Удаление пользователя по id.")
    @DeleteMapping("/{id}")
    public void deleteUser(@ApiParam("ID пользователя.") @PathVariable("id") Long id) {
        userService.deleteUser(id);
    }
}
