package com.tunkenov.user_registration.service;

import com.tunkenov.user_registration.dto.UserDTO;
import com.tunkenov.user_registration.mapping.EntityMapping;
import com.tunkenov.user_registration.model.entity.User;
import com.tunkenov.user_registration.model.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDTO> findAll() {
        return EntityMapping.mapToUserDTOList(userRepository.findAll());
    }

    public UserDTO getOne(Long id) {
        return EntityMapping.mapToUserDTO(userRepository.getOne(id));
    }

    public UserDTO saveUser(UserDTO userDTO) {
        userRepository.save(EntityMapping.mapToUser(userDTO));

        return userDTO;
    }

    public UserDTO updateUser(Long id, UserDTO userDTO) {
        User user = EntityMapping.mapToUser(userDTO);
        user.setId(id);

        userRepository.save(user);

        return userDTO;
    }


    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
