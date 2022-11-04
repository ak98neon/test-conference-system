package com.redhash.conference.adaptors.api;

import com.github.database.rider.spring.api.DBRider;
import io.restassured.RestAssured;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DBRider
@Slf4j
@ActiveProfiles("test")
public abstract class AbstractApiTest {
    @LocalServerPort
    protected int port;

    @BeforeEach
    void init() {
        RestAssured.port = port;
    }
}
