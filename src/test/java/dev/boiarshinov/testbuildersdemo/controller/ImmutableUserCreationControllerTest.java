package dev.boiarshinov.testbuildersdemo.controller;

import dev.boiarshinov.testbuildersdemo.BaseControllerTest;
import dev.boiarshinov.testbuildersdemo.controller.request.ImmutableUserCreationRequest;
import dev.boiarshinov.testbuildersdemo.util.ImmutableUserLombokFactory;
import dev.boiarshinov.testbuildersdemo.util.ImmutableUserPlainFactory;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ImmutableUserCreationControllerTest extends BaseControllerTest {

    @Test
    void withPlainBuilder() throws Exception {
        final ImmutableUserCreationRequest requestBody =
            ImmutableUserPlainFactory.hardcode().build();

        super.mockMvc.perform(
            MockMvcRequestBuilders.post("/immutable-user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(super.jsonMapper.writeValueAsString(requestBody)))
            .andExpect(status().isOk());
    }

    @Test
    void withLombokBuilder() throws Exception {
        final ImmutableUserCreationRequest requestBody =
            ImmutableUserLombokFactory.builder().build().toUserCreationRequest();

        super.mockMvc.perform(
            MockMvcRequestBuilders.post("/immutable-user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(super.jsonMapper.writeValueAsString(requestBody)))
            .andExpect(status().isOk());
    }
}
