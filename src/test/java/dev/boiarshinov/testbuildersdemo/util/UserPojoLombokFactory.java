package dev.boiarshinov.testbuildersdemo.util;

import dev.boiarshinov.testbuildersdemo.controller.request.UserCreationRequest;

public final class UserPojoLombokFactory {

    private UserPojoLombokFactory() {}

    public static UserCreationRequest.UserCreationRequestBuilder hardcode() {
        return UserCreationRequest.builder()
            .firstName("Josh")
            .secondName("Long")
            .phone("8005553535")
            .inn("796166717907");
    }
}
