package com.letscode.banco.service;

import com.letscode.banco.model.User;
import com.letscode.banco.request.UserRequest;
import java.util.Optional;

public interface UserService {
    User create(UserRequest userRequest);

    Optional<User> findById(Integer id);
}
