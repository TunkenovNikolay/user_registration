package com.tunkenov.user_registration.mapping;

import com.tunkenov.user_registration.dto.UserDTO;
import com.tunkenov.user_registration.model.entity.User;

import java.util.List;
import java.util.stream.Collectors;

public class EntityConverter {

    public static UserDTO mapToUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setFirst_name(user.getFirstName());
        userDTO.setLast_Name(user.getLastName());
        userDTO.setId(user.getId());
        return userDTO;
    }

    public static List<UserDTO> mapToUserDTOList(List<User> userList) {
        return userList.stream()
                .map(EntityConverter::mapToUserDTO)
                .collect(Collectors.toList());
    }

    public static User mapToUser(UserDTO userDTO){
        User user = new User();
        user.setFirstName(userDTO.getFirst_name());
        user.setLastName(userDTO.getLast_Name());

        return user;
    }
}
