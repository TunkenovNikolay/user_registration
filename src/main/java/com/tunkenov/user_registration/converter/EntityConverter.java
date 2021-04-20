package com.tunkenov.user_registration.converter;

import com.tunkenov.user_registration.dto.InputUserDTO;
import com.tunkenov.user_registration.dto.OutputUserDTO;
import com.tunkenov.user_registration.model.entity.User;

import java.util.List;
import java.util.stream.Collectors;

public class EntityConverter {

    public static OutputUserDTO mapToOutputUserDTO(User user) {
        return new OutputUserDTO(user.getId(), user.getFirstName(), user.getLastName());
    }

    public static List<OutputUserDTO> mapToOutputUserDTOList(List<User> userList) {
        return userList.stream()
                .map(EntityConverter::mapToOutputUserDTO)
                .collect(Collectors.toList());
    }

    public static User mapToUser(InputUserDTO inputUserDTO) {
        User user = new User();
        user.setFirstName(inputUserDTO.getFirstName());
        user.setLastName(inputUserDTO.getLastName());

        return user;
    }

    public static User mapToUser(Long id, InputUserDTO inputUserDTO) {
        User user = new User();
        user.setFirstName(inputUserDTO.getFirstName());
        user.setLastName(inputUserDTO.getLastName());
        user.setId(id);

        return user;
    }

    public static User mapToUser(OutputUserDTO outputUserDTO) {
        User user = new User();
        user.setFirstName(outputUserDTO.getFirstName());
        user.setLastName(outputUserDTO.getLastName());
        user.setId(outputUserDTO.getId());

        return user;
    }
}
