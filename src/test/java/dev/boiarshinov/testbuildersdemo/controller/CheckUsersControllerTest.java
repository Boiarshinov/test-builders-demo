package dev.boiarshinov.testbuildersdemo.controller;

import dev.boiarshinov.testbuildersdemo.controller.request.CheckUsersRequest;
import dev.boiarshinov.testbuildersdemo.util.CheckUsersRequestFactory;
import dev.boiarshinov.testbuildersdemo.util.TestUtils;
import org.junit.jupiter.api.Test;

public class CheckUsersControllerTest {

    @Test
    void byDayWithTestUtils() {
        final CheckUsersRequest checkUsersRequest = TestUtils.createCheckUserRequest()
            .from(null)
            .to(null)
            .build();
    }

    @Test
    void byFromToWithTestUtils() {
        final CheckUsersRequest checkUsersRequest = TestUtils.createCheckUserRequest()
            .day(null)
            .build();
    }

    @Test
    void byDayWithFactory() {
        final CheckUsersRequest checkUsersRequest = CheckUsersRequestFactory.byDay().build();
    }

    @Test
    void byFromToWithFactory() {
        final CheckUsersRequest checkUsersRequest = CheckUsersRequestFactory.byInterval().build();
    }
}
