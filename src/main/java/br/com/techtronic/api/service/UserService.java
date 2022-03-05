package br.com.techtronic.api.service;

import br.com.techtronic.api.domain.User;

import java.util.List;

public interface UserService {

    User findById(Integer id);
    public List<User> findAll();
}
