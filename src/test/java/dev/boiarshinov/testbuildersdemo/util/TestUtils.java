package dev.boiarshinov.testbuildersdemo.util;

import dev.boiarshinov.testbuildersdemo.controller.request.CheckUsersRequest;
import dev.boiarshinov.testbuildersdemo.controller.request.UserCreationRequest;
import org.hibernate.validator.constraints.ru.INN;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public final class TestUtils {

    private TestUtils() { }

    public static UserCreationRequest createUserRequest() {
        return createUserRequest("796166717907");
    }

    public static UserCreationRequest createUserRequest(String inn) {
        final UserCreationRequest userCreationRequest = new UserCreationRequest();
        userCreationRequest.setFirstName("Claudia");
        userCreationRequest.setSecondName("Coca");
        userCreationRequest.setPhone("8005553535");
        userCreationRequest.setInn(inn);
        return userCreationRequest;
    }

    public static CheckUsersRequest.CheckUsersRequestBuilder createCheckUserRequest() {
        return CheckUsersRequest.builder()
            .type(INN.Type.INDIVIDUAL)
            .day(LocalDate.of(2021, 3, 8))
            .from(LocalDateTime.of(
                LocalDate.of(2021, 3, 8),
                LocalTime.of(10, 0)
                )
            )
            .to(LocalDateTime.of(
                LocalDate.of(2021, 3, 8),
                LocalTime.of(20, 30)
                )
            );
    }
}
