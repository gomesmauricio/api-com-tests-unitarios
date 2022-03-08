package br.com.techtronic.api.mother;

import br.com.techtronic.api.domain.User;
import br.com.techtronic.api.domain.dto.UserDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserMother {

    public static User getUser(){
        User user = new User();
        user.setId(1);
        user.setName("Test Silva");
        user.setEmail("test@mail.com");
        user.setPassword("123");

        return user;
    }

    public static UserDTO getUserDTO(){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1);
        userDTO.setName("Test Silva");
        userDTO.setEmail("test@mail.com");
        userDTO.setPassword("123");
        return userDTO;
    }

    public static List<User> getUserList(){
        List<User> userList = new ArrayList<>();
        userList.add(getUser());
        return userList;
    }

    public static List<UserDTO> getUserDtoList(){
        List<UserDTO> userDTOList = new ArrayList<>();
        userDTOList.add(getUserDTO());
        return userDTOList;
    }

    public  static  Optional<User> getUserOptional(){
        Optional<User> optionalUser =  Optional.of(getUser());
        return optionalUser;
    }

}
