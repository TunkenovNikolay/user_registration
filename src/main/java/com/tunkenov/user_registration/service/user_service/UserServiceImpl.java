package com.tunkenov.user_registration.service.user_service;

import com.tunkenov.user_registration.dto.InputUserDTO;
import com.tunkenov.user_registration.dto.OutputUserDTO;
import com.tunkenov.user_registration.converter.EntityConverter;
import com.tunkenov.user_registration.exceptions.MyEntityNotFoundException;
import com.tunkenov.user_registration.model.entity.User;
import com.tunkenov.user_registration.model.repository.UserRepository;
import com.tunkenov.user_registration.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<OutputUserDTO> findAll() {
        return EntityConverter.mapToOutputUserDTOList(userRepository.findAll());
    }

    @Override
    public OutputUserDTO findById(Long id) {
        return EntityConverter.mapToOutputUserDTO(userRepository.findById(id).orElseThrow(() -> new MyEntityNotFoundException(id)));
    }

    @Override
    public OutputUserDTO saveUser(InputUserDTO inputUserDTO) {
        return EntityConverter.mapToOutputUserDTO(userRepository.save(EntityConverter.mapToUser(inputUserDTO)));
    }

    @Override
    public OutputUserDTO updateUser(Long id, InputUserDTO inputUserDTO) {
        OutputUserDTO outputUserDTO = findById(id);

        User user = EntityConverter.mapToUser(outputUserDTO);
        user.setFirstName(inputUserDTO.getFirstName());
        user.setLastName(inputUserDTO.getLastName());

        return EntityConverter.mapToOutputUserDTO(userRepository.save(user));
    }

    @Override
    public void deleteUser(Long id) {
        findById(id);
        userRepository.deleteById(id);
    }
}
