package org.krzysztof.users.register.controller;

import org.krzysztof.users.register.domain.model.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class RegisterUserController {

    @RequestMapping(value = "register", method = POST)
    @ResponseStatus(CREATED)
    public User register(@RequestBody User user) {
        return user;
    }
}
