package ru.library.configuration

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.models.Components
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@OpenAPIDefinition
class OpenApiConfiguration {
    @Bean
    fun publicApi(): OpenAPI {
        return OpenAPI()
                .components(Components())
                .info(Info()
                        .title("Library")
                        .version("1.0.0"))
    }
}