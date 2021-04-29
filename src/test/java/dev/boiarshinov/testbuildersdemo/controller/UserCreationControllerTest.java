package dev.boiarshinov.testbuildersdemo.controller;

import dev.boiarshinov.testbuildersdemo.BaseControllerTest;
import dev.boiarshinov.testbuildersdemo.controller.request.UserCreationRequest;
import dev.boiarshinov.testbuildersdemo.util.TestUtils;
import dev.boiarshinov.testbuildersdemo.util.UserPojoLombokFactory;
import dev.boiarshinov.testbuildersdemo.util.UserPojoPlainFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class UserCreationControllerTest extends BaseControllerTest {

    @Test
    @DisplayName("Create POJO in method body")
    void allInMethod() throws Exception {
        final UserCreationRequest userCreationRequest = new UserCreationRequest();
        userCreationRequest.setFirstName("Claudia");
        userCreationRequest.setSecondName("Coca");
        userCreationRequest.setPhone("8005553535");
        userCreationRequest.setInn("796166717907");

        mockMvc.perform(
            MockMvcRequestBuilders.post("/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(super.jsonMapper.writeValueAsString(userCreationRequest)))
            .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Create POJO in private method")
    void inPrivateMethod() throws Exception {
        final UserCreationRequest requestBody = this.createUserCreationRequest();

        mockMvc.perform(
            MockMvcRequestBuilders.post("/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(super.jsonMapper.writeValueAsString(requestBody)))
            .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Create POJO in utils class")
    void inUtilsClass() throws Exception {
        final UserCreationRequest userRequest = TestUtils.createUserRequest();

        mockMvc.perform(
            MockMvcRequestBuilders.post("/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(super.jsonMapper.writeValueAsString(userRequest)))
            .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Create invalid POJO in utils class")
    void invalidInUtilsClass() throws Exception {
        final UserCreationRequest requestBody = TestUtils.createUserRequest("012345678901");

        mockMvc.perform(
            MockMvcRequestBuilders.post("/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(super.jsonMapper.writeValueAsString(requestBody)))
            .andExpect(status().isBadRequest());
    }

    @Test
    void withPlainBuilder() throws Exception {
        final UserCreationRequest requestBody = UserPojoPlainFactory.hardcode().build();

        mockMvc.perform(
            MockMvcRequestBuilders.post("/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(super.jsonMapper.writeValueAsString(requestBody)))
            .andExpect(status().isOk());
    }

    @Test
    void innValidationErrorWithPlainBuilder() throws Exception {
        final UserCreationRequest requestBody = UserPojoPlainFactory.hardcode()
            .inn("012345678901")
            .build();

        mockMvc.perform(
            MockMvcRequestBuilders.post("/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(super.jsonMapper.writeValueAsString(requestBody)))
            .andExpect(status().isBadRequest());
    }

    @Test
    void withLombokBuilder() throws Exception {
        final UserCreationRequest requestBody = UserPojoLombokFactory.hardcode().build();

        mockMvc.perform(
            MockMvcRequestBuilders.post("/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(super.jsonMapper.writeValueAsString(requestBody)))
            .andExpect(status().isOk());
    }

    private UserCreationRequest createUserCreationRequest() {
        final UserCreationRequest userCreationRequest = new UserCreationRequest();
        userCreationRequest.setFirstName("Claudia");
        userCreationRequest.setSecondName("Coca");
        userCreationRequest.setPhone("8005553535");
        userCreationRequest.setInn("796166717907");
        return userCreationRequest;
    }
}