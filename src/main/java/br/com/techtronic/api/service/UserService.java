package br.com.techtronic.api.service;

import br.com.techtronic.api.domain.User;

public interface UserService {

    User findById(Integer id);
}
