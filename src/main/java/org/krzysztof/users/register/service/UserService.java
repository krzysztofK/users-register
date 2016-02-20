package org.krzysztof.users.register.service;

import org.krzysztof.users.register.domain.model.User;
import org.krzysztof.users.register.domain.model.UserNameNotUniqueException;
import org.krzysztof.users.register.domain.repository.UsersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UsersRepository usersRepository;

    public User addUser(User user) {
        try {
            return usersRepository.insert(user);
        } catch (DuplicateKeyException e) {
            logger.info("Error during insertion of user to database {}", user, e);
            throw new UserNameNotUniqueException();
        }
    }
}