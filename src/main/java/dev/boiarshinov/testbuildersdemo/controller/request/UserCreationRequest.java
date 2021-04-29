package dev.boiarshinov.testbuildersdemo.controller.request;

import dev.boiarshinov.testbuildersdemo.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.ru.INN;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@Builder @NoArgsConstructor @AllArgsConstructor
public class UserCreationRequest {

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String secondName;

    @NotNull
    @Pattern(regexp = "\\d{10}")
    private String phone;

    @NotNull
    @INN(type = INN.Type.INDIVIDUAL)
    private String inn;

    public User toEntity() {
        return new User(); //todo implement
    }
}
