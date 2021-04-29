package dev.boiarshinov.testbuildersdemo.controller;

import dev.boiarshinov.testbuildersdemo.controller.request.ImmutableUserCreationRequest;
import dev.boiarshinov.testbuildersdemo.controller.request.UserCreationRequest;
import dev.boiarshinov.testbuildersdemo.model.User;
import dev.boiarshinov.testbuildersdemo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
@Validated
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @PostMapping("/user")
    public void createUser(
        @RequestBody @Validated final UserCreationRequest userCreationRequest
    ) {
        final User user = userCreationRequest.toEntity();
        service.save(user);
    }

    @PostMapping("/immutable-user")
    public void createUser(
        @RequestBody @Validated final ImmutableUserCreationRequest userCreationRequest
    ) {
        final User user = userCreationRequest.toEntity();
        service.save(user);
    }

    @ExceptionHandler
    public ResponseEntity<String> handleValidationExceptions(final MethodArgumentNotValidException exception) {
        return ResponseEntity.badRequest().body(exception.getMessage());
    }

    @ExceptionHandler
    public ResponseEntity<String> catchThemAll(final Exception exception) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error!");
    }
}
