package com.tunkenov.user_registration.service;

import com.tunkenov.user_registration.dto.InputUserDTO;
import com.tunkenov.user_registration.dto.OutputUserDTO;
import com.tunkenov.user_registration.converter.EntityConverter;
import com.tunkenov.user_registration.exceptions.MyEntityNotFoundException;
import com.tunkenov.user_registration.model.entity.User;
import com.tunkenov.user_registration.model.repository.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private static final Logger logger = LogManager.getLogger();
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
        OutputUserDTO outputUserDTO = findById(id);

        User user = EntityConverter.mapToUser(outputUserDTO);
        user.setFirstName(inputUserDTO.getFirstName());
        user.setLastName(inputUserDTO.getLastName());

        return EntityConverter.mapToOutputUserDTO(userRepository.save(user));
    }

    public void deleteUser(Long id) {
        findById(id);
        userRepository.deleteById(id);
    }
}
