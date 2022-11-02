package com.redhash.conference.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(title = "Conference API", description = "Conference API", version = "1.0.0"),
        servers = @Server(url = "http://localhost:8080")
)
@Configuration
public class ApiConfig {
}
