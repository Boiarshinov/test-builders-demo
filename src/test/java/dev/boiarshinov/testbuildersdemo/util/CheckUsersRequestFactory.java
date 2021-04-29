package dev.boiarshinov.testbuildersdemo.util;

import dev.boiarshinov.testbuildersdemo.controller.request.CheckUsersRequest;
import org.hibernate.validator.constraints.ru.INN;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class CheckUsersRequestFactory {

    CheckUsersRequest.CheckUsersRequestBuilder byDay() {
        return CheckUsersRequest.builder()
            .type(INN.Type.INDIVIDUAL)
            .day(LocalDate.of(2021, 3, 8));
    }

    CheckUsersRequest.CheckUsersRequestBuilder byInterval() {
        return CheckUsersRequest.builder()
            .type(INN.Type.INDIVIDUAL)
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
