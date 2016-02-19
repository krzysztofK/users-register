package org.krzysztof.users.register.domain.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Pattern;

public class User {

    @Pattern(regexp = "^[a-zA-Z0-9]{5,}$", message = "Invalid name")
    private final String name;
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])\\w{8,}$", message = "Invalid password")
    private final String password;

    @JsonCreator
    public User(@JsonProperty("name") String name, @JsonProperty("password") String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}