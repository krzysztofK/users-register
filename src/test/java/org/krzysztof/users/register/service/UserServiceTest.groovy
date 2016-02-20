package org.krzysztof.users.register.service

import org.krzysztof.users.register.domain.model.User
import org.krzysztof.users.register.domain.model.UserNameNotUniqueException
import org.krzysztof.users.register.domain.repository.UsersRepository
import org.springframework.dao.DuplicateKeyException
import spock.lang.Specification

class UserServiceTest extends Specification {

    def usersRepository = Mock(UsersRepository)
    def userService = new UserService(usersRepository: usersRepository)

    def "should throw user name not unique exception if user name not unique"() {
        given:
        usersRepository.insert(_) >> { throw new DuplicateKeyException('Duplicate') }

        when:
        userService.addUser(new User('notUnique', 'password'))

        then:
        thrown UserNameNotUniqueException
    }

    def "should return inserted user if insert successful"() {
        given:
        def user = new User('user', 'password')
        usersRepository.insert(user) >> user

        when:
        def resutlUser = userService.addUser(user)

        then:
        resutlUser == user
    }
}