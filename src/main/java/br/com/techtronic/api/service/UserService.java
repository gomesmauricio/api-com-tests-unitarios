package br.com.techtronic.api.service;

import br.com.techtronic.api.domain.User;
import br.com.techtronic.api.domain.dto.UserDTO;

import java.util.List;

public interface UserService {

    User findById(Integer id);
    public List<User> findAll();
    User create(UserDTO userDTO);
}
