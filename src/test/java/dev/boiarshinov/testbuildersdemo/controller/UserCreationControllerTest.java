package dev.boiarshinov.testbuildersdemo.controller;

import dev.boiarshinov.testbuildersdemo.BaseControllerTest;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.testcontainers.shaded.org.apache.commons.lang.RandomStringUtils;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class UserCreationControllerTest extends BaseControllerTest {

    @Test
    void withoutBuilder() throws Exception {
        final UserCreationRequest requestBody = this.createUserCreationRequest();

        super.mockMvc.perform(
            MockMvcRequestBuilders.post("/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(super.jsonMapper.writeValueAsString(requestBody)))
            .andExpect(status().isOk());

        //todo look at the DB and assert
    }

    private UserCreationRequest createUserCreationRequest() {
        final UserCreationRequest userCreationRequest = new UserCreationRequest();
        userCreationRequest.setFirstName(RandomStringUtils.randomAlphabetic(5));
        userCreationRequest.setSecondName(RandomStringUtils.randomAlphabetic(8));
        userCreationRequest.setPhone(RandomStringUtils.randomNumeric(10));
        userCreationRequest.setInn(RandomStringUtils.randomNumeric(12));
        return userCreationRequest;
    }

    @Test
    void withPlainBuilder() throws Exception {
        final UserCreationRequest requestBody = UserPojoPlainBuilder.hardcode().build();

        super.mockMvc.perform(
            MockMvcRequestBuilders.post("/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(super.jsonMapper.writeValueAsString(requestBody)))
            .andExpect(status().isOk());

        //todo look at the DB and assert
    }
}