package dev.boiarshinov.testbuildersdemo.util;

import dev.boiarshinov.testbuildersdemo.controller.request.ImmutableUserCreationRequest;

public final class ImmutableUserPlainFactory {

    private String firstName = "Tagir";
    private String secondName = "Valeev";
    private String phone = "8005553535";
    private String inn = "796166717907";

    private ImmutableUserPlainFactory() {}

    public static ImmutableUserPlainFactory hardcode() {
        return new ImmutableUserPlainFactory();
    }

    public ImmutableUserPlainFactory firstName(final String firstName) {
        this.firstName = firstName;
        return this;
    }

    public ImmutableUserPlainFactory secondName(final String secondName) {
        this.secondName = secondName;
        return this;
    }

    public ImmutableUserPlainFactory phone(final String phone) {
        this.phone = phone;
        return this;
    }

    public ImmutableUserPlainFactory inn(final String inn) {
        this.inn = inn;
        return this;
    }

    public ImmutableUserCreationRequest build() {
        return new ImmutableUserCreationRequest(
            firstName,
            secondName,
            phone,
            inn
        );
    }
}
