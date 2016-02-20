package org.krzysztof.users.register.controller;

import org.krzysztof.users.register.domain.model.User;
import org.krzysztof.users.register.domain.model.UserNameNotUniqueException;
import org.krzysztof.users.register.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class RegisterUserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "register", method = POST)
    @ResponseStatus(CREATED)
    public User register(@Valid @RequestBody User user) {
        return userService.addUser(user);
    }

    @ResponseStatus(value = CONFLICT, reason = "User name not unique")
    @ExceptionHandler(UserNameNotUniqueException.class)
    public void userNameConflict() {
    }
}