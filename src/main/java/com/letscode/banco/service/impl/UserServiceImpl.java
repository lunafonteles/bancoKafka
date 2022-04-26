package com.letscode.banco.service.impl;

import com.letscode.banco.client.GetCpfValidator;
import com.letscode.banco.client.ValidatorInfo;
import com.letscode.banco.model.User;
import com.letscode.banco.repository.UserRepository;
import com.letscode.banco.request.UserRequest;
import com.letscode.banco.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    GetCpfValidator getCpfValidator;

    @Override
    public User create(UserRequest userRequest) {
        User user = new User();
        user.setCpf(userRequest.getCpf());
        user.setName(userRequest.getName());

        userRepository.save(user);
        return user;
    }

    @Override
    public Optional<User> findById(Integer id) {
        Optional<User> user = userRepository.findById(id);
        return user;
    }
}
