package com.example.bookstore;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.media.Content;
import io.swagger.v3.oas.models.media.MediaType;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.security.OAuthFlow;
import io.swagger.v3.oas.models.security.OAuthFlows;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        final String securitySchemeName = "bearerAuth";

        return new OpenAPI()
                .addSecurityItem(new SecurityRequirement().addList(securitySchemeName))
                .components(new Components()
                        .addSecuritySchemes(securitySchemeName, new io.swagger.v3.oas.models.security.SecurityScheme()
                                .type(io.swagger.v3.oas.models.security.SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT")
                                .in(io.swagger.v3.oas.models.security.SecurityScheme.In.HEADER)
                                .name("Authorization")
                                .flows(new OAuthFlows()
                                        .password(new OAuthFlow()
                                                .tokenUrl("/tokenEndpoint")))))
                .path("/publicEndpoint", new io.swagger.v3.oas.models.PathItem()
                        .get(new io.swagger.v3.oas.models.Operation()
                                .operationId("getPublicData")
                                .summary("Get public data")
                                .addTagsItem("Public")
                                .responses(new io.swagger.v3.oas.models.responses.ApiResponses()
                                        .addApiResponse("200", new io.swagger.v3.oas.models.responses.ApiResponse()
                                                .description("Successful operation")
                                                .content(new Content()
                                                        .addMediaType("application/json", new MediaType()
                                                                .schema(new Schema())))))
                                .security(new java.util.ArrayList<>()))); // Brak wymagań dotyczących autoryzacji
    }
}
