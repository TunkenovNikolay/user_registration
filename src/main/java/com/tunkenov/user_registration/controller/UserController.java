package com.tunkenov.user_registration.controller;

import com.tunkenov.user_registration.dto.InputUserDTO;
import com.tunkenov.user_registration.dto.OutputUserDTO;
import com.tunkenov.user_registration.service.UserService;
import com.tunkenov.user_registration.service.user_service.UserServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;


import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/users")
@RestController
public class UserController {
    private static final Logger logger = LogManager.getLogger();

    private final UserService userService;

    public UserController(UserServiceImpl userServiceImpl) {
        this.userService = userServiceImpl;
    }

    @Operation(description = "Загрузка всех пользователей.")
    @GetMapping
    public List<OutputUserDTO> findAllUsers() {
        return userService.findAll();
    }

    @Operation(description = "Загрузка пользователя по id.")
    @GetMapping("/{id}")
    public OutputUserDTO findUser(@Parameter(description = "ID пользователя.") @PathVariable("id") Long id) {
        return userService.findById(id);
    }

    @Operation(description = "Регистрация нового пользователя.")
    @PostMapping
    @ResponseBody
    public OutputUserDTO saveUser(@Parameter(description = "Данные пользователя (Имя и Фамилия).") @RequestBody InputUserDTO inputUserDTO) {
        return userService.saveUser(inputUserDTO);
    }

    @Operation(description = "Редактирование информации пользователя по id.")
    @PutMapping("/{id}")
    @ResponseBody
    public OutputUserDTO updateUser(@Parameter(description = "ID пользователя.") @PathVariable("id") Long id,
                                    @Parameter(description = "Новые данные пользователя (Имя и Фамилия.") @RequestBody InputUserDTO inputUserDTO) {
        return userService.updateUser(id, inputUserDTO);
    }

    @Operation(description = "Удаление пользователя по id.")
    @DeleteMapping("/{id}")
    public void deleteUser(@Parameter(description = "ID пользователя.") @PathVariable("id") Long id) {
        userService.deleteUser(id);
    }
}
