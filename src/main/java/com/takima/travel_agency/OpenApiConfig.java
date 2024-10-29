package com.takima.travel_agency;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Amine Reda OUMEZIANE",
                        email = "aminereda.devs@gmail.com"
                ),
                title = "Travel agency backend",
                description = "OpenAPI documentation for Travel agency",
                version = "1.0",
                termsOfService = "Terms of service"
        ),
        servers = {
                @Server(
                        description = "Local ENV",
                        url = "http://localhost:8080/api"
                )
        }
)
public class OpenApiConfig {
}
