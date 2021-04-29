package dev.boiarshinov.testbuildersdemo.util;

import dev.boiarshinov.testbuildersdemo.controller.request.ImmutableUserCreationRequest;
import lombok.Builder;

@Builder
public final class ImmutableUserLombokFactory {

    @Builder.Default private final String firstName = "Tagir";
    @Builder.Default private final String secondName = "Valeev";
    @Builder.Default private final String phone = "8005553535";
    @Builder.Default private final String inn = "796166717907";

    public ImmutableUserCreationRequest toUserCreationRequest() {
        return new ImmutableUserCreationRequest(
            firstName,
            secondName,
            phone,
            inn
        );
    }
}
