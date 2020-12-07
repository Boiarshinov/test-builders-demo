package dev.boiarshinov.testbuildersdemo.controller;

import dev.boiarshinov.testbuildersdemo.service.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@RequiredArgsConstructor
public class ImmutableUserCreationRequest {

    @NotNull
    private final Long id;

    @NotEmpty
    private final String firstName;

    @NotEmpty
    private final String secondName;

    @NotNull
    @Pattern(regexp = "\\d{10}")
    private final String phone;

    @NotNull
    @Pattern(regexp = "\\d{12}")
    @ValidInnHash
    private final String inn;

    public User toEntity() {
        return new User(); //todo implement
    }
}
