package dev.boiarshinov.testbuildersdemo.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.boiarshinov.testbuildersdemo.model.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.ru.INN;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@RequiredArgsConstructor
public class ImmutableUserCreationRequest {

    @NotEmpty
    @JsonProperty("firstName")
    private final String firstName;

    @NotEmpty
    @JsonProperty("secondName")
    private final String secondName;

    @NotNull
    @Pattern(regexp = "\\d{10}")
    @JsonProperty("phone")
    private final String phone;

    @NotNull
    @INN(type = INN.Type.INDIVIDUAL)
    @JsonProperty("inn")
    private final String inn;

    public User toEntity() {
        return new User(); //todo implement
    }
}
