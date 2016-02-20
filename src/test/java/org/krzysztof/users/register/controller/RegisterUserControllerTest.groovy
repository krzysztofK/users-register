package org.krzysztof.users.register.controller

import org.krzysztof.users.register.domain.repository.UsersRepository
import org.krzysztof.users.register.service.UserService
import org.springframework.dao.DuplicateKeyException
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import spock.lang.Specification

import static java.nio.charset.Charset.forName
import static org.springframework.http.MediaType.APPLICATION_JSON
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

class RegisterUserControllerTest extends Specification {

    def repository = Mock(UsersRepository)
    def controller = new RegisterUserController(userService: new UserService(usersRepository: repository))
    def mockMvc = MockMvcBuilders.standaloneSetup(controller).build()
    def contentType = new MediaType(APPLICATION_JSON.type, APPLICATION_JSON.subtype, forName("utf8"));

    def "should return bad request if invalid input"() {
        given:
        def requestContent = '{"name":"user", "password": "password"}'

        expect:
        mockMvc.perform(post('/register').accept(APPLICATION_JSON).contentType(contentType).content(requestContent))
                .andExpect(status().isBadRequest())
    }

    def "should return conflict if user name already used"() {
        given:
        def requestContent = '{"name":"user1", "passwordA1": "password"}'
        repository.insert(_) >> { throw new DuplicateKeyException('message') }

        expect:
        mockMvc.perform(post('/register').accept(APPLICATION_JSON).contentType(contentType).content(requestContent))
                .andExpect(status().isConflict())
    }

    def "should return created if no error during request processing"() {
        given:
        def requestContent = '{"name":"user1", "passwordA1": "password"}'

        expect:
        mockMvc.perform(post('/register').accept(APPLICATION_JSON).contentType(contentType).content(requestContent))
                .andExpect(status().isCreated())
    }
}