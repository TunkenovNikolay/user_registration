package com.tunkenov.user_registration.service;

import com.tunkenov.user_registration.dto.InputUserDTO;
import com.tunkenov.user_registration.dto.OutputUserDTO;
import com.tunkenov.user_registration.converter.EntityConverter;
import com.tunkenov.user_registration.exceptions.MyEntityNotFoundException;
import com.tunkenov.user_registration.model.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<OutputUserDTO> findAll() {
        return EntityConverter.mapToOutputUserDTOList(userRepository.findAll());
    }

    public OutputUserDTO findById(Long id) {
        return EntityConverter.mapToOutputUserDTO(userRepository.findById(id).orElseThrow(() -> new MyEntityNotFoundException(id)));
    }

    public OutputUserDTO saveUser(InputUserDTO inputUserDTO) {
        return EntityConverter.mapToOutputUserDTO(userRepository.save(EntityConverter.mapToUser(inputUserDTO)));
    }

    public OutputUserDTO updateUser(Long id, InputUserDTO inputUserDTO) {
        return EntityConverter.mapToOutputUserDTO(userRepository.save(EntityConverter.mapToUser(findById(id))));
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
