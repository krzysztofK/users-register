package org.krzysztof.users.register.domain.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Pattern;

@Document
public class User {

    @Indexed(unique = true)
    @Pattern(regexp = "^[a-zA-Z0-9]{5,}$", message = "Invalid name")
    private final String name;
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])\\w{8,}$", message = "Invalid password")
    private final String password;

    @JsonCreator
    @PersistenceConstructor
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