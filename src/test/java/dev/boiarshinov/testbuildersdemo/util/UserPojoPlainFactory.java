package dev.boiarshinov.testbuildersdemo.util;

import dev.boiarshinov.testbuildersdemo.controller.request.UserCreationRequest;

public final class UserPojoPlainFactory {
    private final UserCreationRequest pojo;

    private UserPojoPlainFactory() {
        this.pojo = new UserCreationRequest();
    }

    public static UserPojoPlainFactory hardcode() {
        return new UserPojoPlainFactory()
            .firstName("Josh")
            .secondName("Long")
            .phone("8005553535")
            .inn("796166717907");
    }

    public UserPojoPlainFactory firstName(final String firstName) {
        pojo.setFirstName(firstName);
        return this;
    }

    public UserPojoPlainFactory secondName(final String secondName) {
        pojo.setSecondName(secondName);
        return this;
    }

    public UserPojoPlainFactory phone(final String phone) {
        pojo.setPhone(phone);
        return this;
    }

    public UserPojoPlainFactory inn(final String inn) {
        pojo.setInn(inn);
        return this;
    }

    public UserCreationRequest build() {
        return pojo;
    }
}
