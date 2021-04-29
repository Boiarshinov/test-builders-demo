package dev.boiarshinov.testbuildersdemo.controller.request;

import lombok.Builder;
import lombok.Value;
import org.hibernate.validator.constraints.ru.INN;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Value
@Builder
public class CheckUsersRequest {

    INN.Type type;
    LocalDate day;
    LocalDateTime from;
    LocalDateTime to;
}
