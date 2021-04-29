package dev.boiarshinov.testbuildersdemo.util;

import dev.boiarshinov.testbuildersdemo.controller.request.ImmutableUserCreationRequest;

public final class ImmutableUserPlainBuilder {

    private String firstName = "Tagir";
    private String secondName = "Valeev";
    private String phone = "8005553535";
    private String inn = "796166717907";

    private ImmutableUserPlainBuilder() {}

    public static ImmutableUserPlainBuilder hardcode() {
        return new ImmutableUserPlainBuilder();
    }

    public ImmutableUserPlainBuilder firstName(final String firstName) {
        this.firstName = firstName;
        return this;
    }

    public ImmutableUserPlainBuilder secondName(final String secondName) {
        this.secondName = secondName;
        return this;
    }

    public ImmutableUserPlainBuilder phone(final String phone) {
        this.phone = phone;
        return this;
    }

    public ImmutableUserPlainBuilder inn(final String inn) {
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
