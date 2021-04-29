package dev.boiarshinov.testbuildersdemo.util;

import dev.boiarshinov.testbuildersdemo.controller.request.UserCreationRequest;

public final class UserPojoPlainBuilder {
    private final UserCreationRequest pojo;

    private UserPojoPlainBuilder() {
        this.pojo = new UserCreationRequest();
    }

    public static UserPojoPlainBuilder hardcode() {
        return new UserPojoPlainBuilder()
            .firstName("Josh")
            .secondName("Long")
            .phone("8005553535")
            .inn("796166717907");
    }

    public UserPojoPlainBuilder firstName(final String firstName) {
        pojo.setFirstName(firstName);
        return this;
    }

    public UserPojoPlainBuilder secondName(final String secondName) {
        pojo.setSecondName(secondName);
        return this;
    }

    public UserPojoPlainBuilder phone(final String phone) {
        pojo.setPhone(phone);
        return this;
    }

    public UserPojoPlainBuilder inn(final String inn) {
        pojo.setInn(inn);
        return this;
    }

    public UserCreationRequest build() {
        return pojo;
    }
}
