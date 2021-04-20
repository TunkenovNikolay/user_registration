package com.tunkenov.user_registration.service;

import com.tunkenov.user_registration.dto.InputUserDTO;
import com.tunkenov.user_registration.dto.OutputUserDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<OutputUserDTO> findAll();

    OutputUserDTO findById(Long id);

    OutputUserDTO saveUser(InputUserDTO inputUserDTO);

    OutputUserDTO updateUser(Long id, InputUserDTO inputUserDTO);

    void deleteUser(Long id);
}
