package dev.boiarshinov.testbuildersdemo.controller;

import dev.boiarshinov.testbuildersdemo.service.User;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class UserCreationRequest {

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String secondName;

    @NotNull
    @Pattern(regexp = "\\d{10}")
    private String phone;

    @NotNull
    @Pattern(regexp = "\\d{12}")
    @ValidInnHash
    private String inn;

    public User toEntity() {
        return new User(); //todo
    }
}
