package org.krzysztof.users.register.domain.repository;

import org.krzysztof.users.register.domain.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsersRepository extends MongoRepository<User, String> {
}