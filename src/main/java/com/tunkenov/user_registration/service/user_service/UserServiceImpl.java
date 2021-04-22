package com.tunkenov.user_registration.service.user_service;

import com.tunkenov.user_registration.dto.InputUserDTO;
import com.tunkenov.user_registration.dto.OutputUserDTO;
import com.tunkenov.user_registration.converter.EntityConverter;
import com.tunkenov.user_registration.exceptions.MyEntityNotFoundException;
import com.tunkenov.user_registration.model.entity.User;
import com.tunkenov.user_registration.model.repository.UserRepository;
import com.tunkenov.user_registration.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
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
        User user = EntityConverter.mapToUser(inputUserDTO);
        userRepository.save(user);

        logger.debug("Сохранен в базу данных новый пользователь: " + user);

        return EntityConverter.mapToOutputUserDTO(user);
    }

    @Override
    public OutputUserDTO updateUser(Long id, InputUserDTO inputUserDTO) {
        OutputUserDTO outputUserDTO = findById(id);

        User user = EntityConverter.mapToUser(outputUserDTO);
        user.setFirstName(inputUserDTO.getFirstName());
        user.setLastName(inputUserDTO.getLastName());

        userRepository.save(user);

        logger.debug("Новые данные user под номером id = " + id + " сохранен в базу данных: " + user);

        return EntityConverter.mapToOutputUserDTO(user);
    }

    @Override
    public void deleteUser(Long id) {
        OutputUserDTO outputUserDTO = findById(id);

        userRepository.deleteById(id);

        logger.debug("Удален пользователь: " + outputUserDTO);
    }
}
