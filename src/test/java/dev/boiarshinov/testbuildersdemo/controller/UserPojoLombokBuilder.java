package dev.boiarshinov.testbuildersdemo.controller;

public class UserPojoLombokBuilder {

    public static UserCreationRequest.UserCreationRequestBuilder hardcode() {
        return UserCreationRequest.builder()
            .firstName("Josh")
            .secondName("Long")
            .phone("8005553535")
            .inn("796166717907");
    }
}
